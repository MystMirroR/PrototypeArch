@file:Suppress("unused")

package tk.mystmirror.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun <T> Result<T>.isSuccess(): Boolean {
    return this is Result.Success
}

fun <T> Result<T>.asSuccess(): Result.Success<T> {
    return this as Result.Success<T>
}


@ExperimentalContracts
fun <T> Result<T>.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is Result.Failure<*>)
    }
    return this is Result.Failure<*>
}

fun <T> Result<T>.asFailure(): Result.Failure<*> {
    return this as Result.Failure<*>
}

fun <T : Any> Result<T>.asUseCaseResult(): UseCaseResult<T> {
    return if (this.isSuccess()) {
        UseCaseResult.Success(this.asSuccess().value)
    } else {
        return when (this.asFailure().error) {
            is HttpException -> {
                UseCaseResult.HttpError(this.asFailure().error as HttpException)
            }
            else -> UseCaseResult.Error(this.asFailure().error as Throwable)
        }

    }

}

fun <T, R> Result<T>.map(transform: (value: T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success.Value(transform(value))
        is Result.Failure<*> -> this
    }
}

fun <T, R> Result<T>.flatMap(transform: (result: Result<T>) -> Result<R>): Result<R> {
    return transform(this)
}
