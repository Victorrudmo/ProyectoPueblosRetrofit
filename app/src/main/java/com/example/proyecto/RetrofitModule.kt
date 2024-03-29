package com.example.proyecto

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule{

    /*
    1.- Hilt creará una sóla instancia de Retrofit.
    2.- A partir de la instancia de Retrofit, devolverá una
    única instancia del Servicio.
     */

    private const val URL_BASE_RETROFIT = "http://10.0.2.2/api-pueblos/endp/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(URL_BASE_RETROFIT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    @Singleton
    @Provides
    fun provideServiceApi(retrofit : Retrofit): PueblosApiServiceInterface =
        retrofit
            .create(PueblosApiServiceInterface::class.java)



}