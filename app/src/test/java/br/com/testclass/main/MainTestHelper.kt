package br.com.testclass.main

import br.com.testclass.R
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response


val successResponse = Response.success("teal_200")

val errorResponse = Response.error<String>(
    400,
    ResponseBody.create(
        MediaType.parse("mediaType"), "content"
    )
)

val successState = MainState.Success(MainModel(R.color.teal_200))