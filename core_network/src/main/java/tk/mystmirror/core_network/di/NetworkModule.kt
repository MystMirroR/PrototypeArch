package tk.mystmirror.core_network.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tk.mystmirror.core_network.api.ExampleInterfaceAPI

const val API_MAIN_URL = "https://test.test.com/"


val networkModule = module {
    single {
        createWebService<ExampleInterfaceAPI>(
            okHttpClient = OkHttpClientProvider.createHttpClient(),
            factory = RxJava2CallAdapterFactory.create(),
            baseUrl = API_MAIN_URL
        )
    }
}

/* function to build our Retrofit service */
inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    factory: CallAdapter.Factory,
    baseUrl: String,
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}