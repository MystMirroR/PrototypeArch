package tk.mystmirror.core_data.repo

import tk.mystmirror.core_network.models.TestModel
import tk.mystmirror.result.UseCaseResult

interface RepoInterface {
    suspend fun test(): UseCaseResult<TestModel>
}