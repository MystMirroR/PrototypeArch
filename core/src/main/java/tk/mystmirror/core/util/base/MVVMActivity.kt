package tk.mystmirror.core.util.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect

abstract class MVVMActivity<V : BaseViewModel> :
    AppCompatActivity() {

    protected abstract val viewModel: V

    fun showLoading(isLoading: Boolean) {
        //TODO
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()

    }


    private fun initViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.showLoading.asStateFlow().collect {
                showLoading(it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.showError.collect { showError ->
                //TODO
            }
        }
    }
}
