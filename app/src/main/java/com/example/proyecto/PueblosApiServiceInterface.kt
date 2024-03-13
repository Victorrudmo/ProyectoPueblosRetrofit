package com.example.proyecto

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PueblosApiServiceInterface {

    @POST("auth")
    suspend fun login(@Body loginUser : RequestLoginUser): Response<ResponseLogin>

}