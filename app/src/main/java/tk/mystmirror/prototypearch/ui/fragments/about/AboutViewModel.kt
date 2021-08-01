package tk.mystmirror.prototypearch.ui.fragments.about

import kotlinx.coroutines.flow.MutableStateFlow
import tk.mystmirror.core.util.base.BaseViewModel
import tk.mystmirror.prototypearch.ui.states.BaseState

class AboutViewModel : BaseViewModel() {

    val state: MutableStateFlow<BaseState> = MutableStateFlow(BaseState.LoadingState)

}
