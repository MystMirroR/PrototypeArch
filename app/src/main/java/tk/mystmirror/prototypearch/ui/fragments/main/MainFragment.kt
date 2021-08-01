package tk.mystmirror.prototypearch.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import tk.mystmirror.core.util.base.MVVMFragment
import tk.mystmirror.prototypearch.R
import tk.mystmirror.prototypearch.ui.fragments.main.MainState.*

class MainFragment : MVVMFragment<MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.message.collect { sMessage ->
                message.text = sMessage
            }
        }
        viewModel.timer()

        collectState()
    }

    private fun collectState() {

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                when (state) {
                    is LoadingState -> {
                        renderLoading()
                    }
                    is DataState -> {

                        renderData()
                    }
                    is ErrorState -> {
                        renderError()
                    }
                    is FinishState -> {
                        renderFinish()
                    }
                    else -> {
                        renderLoading()
                    }
                }
            }
        }
    }

    private fun renderFinish() {
        TODO("Not yet implemented")
    }

    private fun renderError() {
        TODO("Not yet implemented")
    }

    private fun renderData() {
        TODO("Not yet implemented")
    }

    private fun renderLoading() {
        TODO("Not yet implemented")
    }


    override val viewModel: MainViewModel by viewModel()

}