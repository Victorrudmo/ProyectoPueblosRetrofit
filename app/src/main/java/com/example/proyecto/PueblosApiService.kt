package com.example.proyecto

import retrofit2.Response
import javax.inject.Inject

class PueblosApiService @Inject constructor(val apiService: PueblosApiServiceInterface) {

    suspend fun getUser(user : RequestLoginUser) : Result<ResponseLogin>{
        try{
            val response : Response<ResponseLogin> = apiService.login(user)
            if (response.isSuccessful){
                response.body()?.let{
                        retUser->
                    return Result.success(retUser)

                }?: return Result.failure(RuntimeException("Respuesta de usuarios nula"))
            }else{
                return Result.failure(RuntimeException("Error en la llamada y sin respuesta"))
            }
        }
        catch (e : Exception){

            return Result.failure(e)
        }
    }
}