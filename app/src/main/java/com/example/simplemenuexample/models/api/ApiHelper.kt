package com.example.simplemenuexample.models.api

import com.example.simplemenuexample.models.data.TestUserData
import retrofit2.Call

interface ApiHelper {
    fun getTestUsers(): Call<TestUserData>
}