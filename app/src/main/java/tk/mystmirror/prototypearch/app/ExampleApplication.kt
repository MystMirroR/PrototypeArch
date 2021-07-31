package tk.mystmirror.prototypearch.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tk.mystmirror.core_data.di.dataModule
import tk.mystmirror.core_network.di.networkModule
import tk.mystmirror.prototypearch.di.appModule

class ExampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@ExampleApplication)
            modules(appModule, networkModule, dataModule)

        }
    }
}