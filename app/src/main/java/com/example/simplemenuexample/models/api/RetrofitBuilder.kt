package com.example.simplemenuexample.models.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
//    private const val BASE_URL ="http://localhost:8080/"
    private const val BASE_URL ="http://10.0.2.2:8080/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiInterface: ApiInterface = getRetrofit().create(ApiInterface::class.java)
}