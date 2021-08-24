package com.example.simplemenuexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemenuexample.models.api.ApiHelperImpl
import com.example.simplemenuexample.models.api.RetrofitBuilder
import com.example.simplemenuexample.models.data.TestUserData
import com.example.simplemenuexample.models.repository.MyRepository
import com.example.simplemenuexample.models.repository.TestRepository
import com.example.simplemenuexample.utils.ResultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestViewModel: ViewModel() {
    private val myRepository: TestRepository = TestRepository()
    private val _allTestUserList = MutableLiveData<ResultResponse<TestUserData>?>()

    fun fetchTestUsers() {
        val apiHelper = ApiHelperImpl(RetrofitBuilder.apiInterface)
        apiHelper.getTestUsers()
            .enqueue(object : Callback<TestUserData> {
                override fun onResponse(call: Call<TestUserData>, response: Response<TestUserData>) {
                    _allTestUserList.postValue(ResultResponse.success(response.body()))
                }

                override fun onFailure(call: Call<TestUserData>, t: Throwable) {
                    _allTestUserList.postValue(ResultResponse.error("Error : {${t.message}}", null))
                }

            })
    }

    fun getTestUsers(): LiveData<ResultResponse<TestUserData>?> {
        return _allTestUserList
    }

}