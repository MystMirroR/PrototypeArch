package tk.mystmirror.prototypearch.ui.fragments.main

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import tk.mystmirror.core.util.base.BaseViewModel
import tk.mystmirror.core_db.prefs.Preferences

class MainViewModel : BaseViewModel() {
    private val prefs: Preferences by inject<Preferences>(clazz = Preferences::class.java)

    @ExperimentalCoroutinesApi
    val message = prefs.testValue.asFlow()

    val state: MutableStateFlow<MainState> = MutableStateFlow(MainState.LoadingState)


    @ExperimentalCoroutinesApi
    fun timer() {
        launch {
            for (i in 1..100) {
                delay(1000)
                prefs.testValue.asCollector().emit(i.toString())
            }
        }
    }

}