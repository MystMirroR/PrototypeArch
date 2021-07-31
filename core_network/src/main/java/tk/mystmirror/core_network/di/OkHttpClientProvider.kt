package tk.mystmirror.core_network.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientProvider {

    fun createHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }
        client.readTimeout(30, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)
        client.addInterceptor(logging)
        return client.build()
    }
}