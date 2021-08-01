package tk.mystmirror.prototypearch.ui.fragments.main

import kotlinx.coroutines.flow.Flow

sealed class MainState {
    object LoadingState : MainState()
    data class DataState(val message: Flow<*>) : MainState()
    data class ErrorState(val error: String) : MainState()
    object FinishState : MainState()
}