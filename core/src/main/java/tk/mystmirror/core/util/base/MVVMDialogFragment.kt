package tk.mystmirror.core.util.base

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

abstract class MVVMDialogFragment<V : BaseViewModel> :
    DialogFragment(), CoroutineScope {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            initViewModel()
        } catch (e: Exception) {
            Log.e("error", e.localizedMessage ?: "Unexpected Error")
        }
    }

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    protected abstract val viewModel: V

    private fun initViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.showLoading.asStateFlow().collect {
                (activity as MVVMActivity<*>).showLoading(it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.showError.collect { showError ->
                //TODO
                Log.e("error", showError)
            }
        }

    }
}
