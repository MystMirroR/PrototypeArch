package tk.mystmirror.prototypearch.ui.fragments.home

import kotlinx.coroutines.flow.Flow

sealed class HomeState {
    object LoadingState : HomeState()
    data class DataState(val message: Flow<*>) : HomeState()
    data class ErrorState(val error: String) : HomeState()
    object FinishState : HomeState()
}
