package tk.mystmirror.prototypearch.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tk.mystmirror.core_db.prefs.Preferences
import tk.mystmirror.prototypearch.app.ExampleApplication.Companion.context
import tk.mystmirror.prototypearch.ui.activities.main.MainActivityViewModel
import tk.mystmirror.prototypearch.ui.fragments.about.AboutViewModel
import tk.mystmirror.prototypearch.ui.fragments.home.HomeViewModel

@ExperimentalCoroutinesApi
val appModule = module {
    viewModel { MainActivityViewModel() }

    viewModel { HomeViewModel() }
    viewModel { AboutViewModel() }

    single { Preferences(context) }
}