package tk.mystmirror.core_data.di

import org.koin.dsl.module
import tk.mystmirror.core_data.repo.RepoImpl
import tk.mystmirror.core_data.repo.RepoInterface


val dataModule = module {

    factory<RepoInterface> { RepoImpl(api = get()) }

}