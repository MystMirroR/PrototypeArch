package tk.mystmirror.core.util.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job


    val showLoading = MutableStateFlow<Boolean>(false)
    val showError = MutableStateFlow<String>("")
    val internetConnection: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val refresh: MutableStateFlow<Boolean> =
        MutableStateFlow(false)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }


}
