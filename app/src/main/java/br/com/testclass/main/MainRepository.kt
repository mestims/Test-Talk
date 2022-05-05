package br.com.testclass.main

class MainRepository(private val api: Api) {

    suspend fun getColorName() = api.getColorNameFromApi()
}