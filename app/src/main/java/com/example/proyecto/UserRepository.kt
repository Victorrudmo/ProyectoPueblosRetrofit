package com.example.proyecto

import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: PueblosApiService
){

    suspend fun getUser(user : User) : User? {
        val userRequest = RequestLoginUser(user.email, user.passw)
        val result = apiService.getUser(userRequest)
        result
            .onSuccess {
                    responseUser->
                return User(

                    responseUser.id,
                    responseUser.token,
                    responseUser.email,
                    "",
                    1,
                    //   responseUser.passw,
                    //  responseUser.disponible,
                    responseUser.image)

            }
            .onFailure {
                    exception ->  println(" ${exception.message}")
            }
        return null
    }
}