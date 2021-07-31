package tk.mystmirror.result

sealed class UseCaseResult<out T : Any> {
    class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    class Error(val exception: Throwable) : UseCaseResult<Nothing>()
    class HttpError(val httpError: HttpException) : UseCaseResult<Nothing>()
}

