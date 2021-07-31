package tk.mystmirror.core_network.api

import retrofit2.http.GET
import tk.mystmirror.core_network.models.TestModel
import tk.mystmirror.result.Result

interface ExampleInterfaceAPI {
    @GET("test")
    suspend fun getSomethingAsync(): Result<TestModel>

}