package com.example.simplemenuexample.models.repository

import androidx.lifecycle.MutableLiveData
import com.example.simplemenuexample.models.data.TestUserData
import com.example.simplemenuexample.utils.ResultResponse

class TestRepository () {
    private val _allTestUserList = MutableLiveData<ResultResponse<TestUserData>?>()

    fun getTestUserList(): MutableLiveData<ResultResponse<TestUserData>?> {
        return _allTestUserList
    }
}