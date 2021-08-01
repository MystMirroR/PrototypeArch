package tk.mystmirror.prototypearch.ui.fragments.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import tk.mystmirror.core.util.base.MVVMFragment
import tk.mystmirror.prototypearch.R
import tk.mystmirror.prototypearch.ui.states.BaseState.*

class AboutFragment : MVVMFragment<AboutViewModel>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        collectState()
    }

    private fun collectState() {

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                when (state) {
                    is LoadingState -> {
                        renderLoading()
                    }
                    is ErrorState -> {
                        renderError()
                    }
                    is FinishState -> {
                        renderFinish()
                    }

                }
            }
        }
    }

    private fun renderFinish() {
        //  TODO("Not yet implemented")
    }

    private fun renderError() {
        //  TODO("Not yet implemented")
    }


    private fun renderLoading() {
        //  TODO("Not yet implemented")
    }


    override val viewModel: AboutViewModel by viewModel()

}