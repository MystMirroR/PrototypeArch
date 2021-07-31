package tk.mystmirror.core_data.repo

import tk.mystmirror.core_network.api.ExampleInterfaceAPI
import tk.mystmirror.core_network.models.TestModel
import tk.mystmirror.result.UseCaseResult
import tk.mystmirror.result.asUseCaseResult

class RepoImpl(private val api: ExampleInterfaceAPI) : RepoInterface {
    override suspend fun test(): UseCaseResult<TestModel> {
        return api.getSomethingAsync().asUseCaseResult()
    }

}
