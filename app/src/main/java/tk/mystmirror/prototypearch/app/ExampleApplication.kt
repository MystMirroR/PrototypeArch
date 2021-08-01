package tk.mystmirror.prototypearch.app

import android.app.Application
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tk.mystmirror.core.di.coreModule
import tk.mystmirror.core_data.di.dataModule
import tk.mystmirror.core_db.di.DBModule
import tk.mystmirror.core_network.di.networkModule
import tk.mystmirror.prototypearch.di.appModule

class ExampleApplication : Application() {

    @ExperimentalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        context = this


        startKoin {
            androidContext(this@ExampleApplication)
            modules(appModule, coreModule, networkModule, dataModule, DBModule)
        }
    }

    companion object {
        lateinit var context: ExampleApplication
    }
}