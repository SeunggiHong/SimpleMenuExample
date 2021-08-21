package com.example.simplemenuexample.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplemenuexample.models.api.ApiHelperImpl
import com.example.simplemenuexample.models.api.RetrofitBuilder
import com.example.simplemenuexample.models.data.TestUserData
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.models.repository.MyRepository
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.utils.ResultResponse
import kotlinx.coroutines.DelicateCoroutinesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val myRepository: MyRepository = MyRepository(application)
    private val _allUserList: LiveData<List<UserData>> = myRepository.getUserList()

    init {
    }

    fun getAllUserList(): LiveData<List<UserData>> {
        Log.d(TAG, "MainViewModel - getAllUserList() called")
        return _allUserList
    }

    @DelicateCoroutinesApi
    fun insertUser(user: UserData) {
        Log.d(TAG, "MainViewModel - insertUser() user = {$user}")
        myRepository.insertUser(user)
    }

    @DelicateCoroutinesApi
    fun deleteUser(user: UserData) {
        Log.d(TAG, "MainViewModel - deleteUser() called")
        myRepository.deleteUser(user)
    }

}