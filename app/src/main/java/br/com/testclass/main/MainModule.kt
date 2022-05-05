package br.com.testclass.main

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainModule = module {

    factory { ColorMapper() }

    factory { get<Retrofit>().create(Api::class.java) }

    factory { MainRepository(get()) }

    viewModel { MainViewModel(get() ,get()) }
}