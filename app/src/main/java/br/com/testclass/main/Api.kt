package br.com.testclass.main

import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/colorName")
    suspend fun getColorNameFromApi(): Response<String>
}