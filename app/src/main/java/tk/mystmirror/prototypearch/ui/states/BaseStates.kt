package tk.mystmirror.prototypearch.ui.states

sealed class BaseState {
    object LoadingState : BaseState()
    data class ErrorState(val error: String) : BaseState()
    object FinishState : BaseState()

}