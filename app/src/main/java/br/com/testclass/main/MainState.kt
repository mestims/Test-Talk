package br.com.testclass.main

sealed class MainState {
    data class Success(val model: MainModel) : MainState()
    data class Error(val error: String?) : MainState()
}