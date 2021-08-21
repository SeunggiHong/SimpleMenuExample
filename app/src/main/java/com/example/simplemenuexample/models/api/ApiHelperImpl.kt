package com.example.simplemenuexample.models.api

import com.example.simplemenuexample.models.data.TestUserData
import retrofit2.Call

class ApiHelperImpl(private val apiInterface: ApiInterface): ApiHelper {
    override fun getTestUsers(): Call<TestUserData> = apiInterface.getUsers()
}