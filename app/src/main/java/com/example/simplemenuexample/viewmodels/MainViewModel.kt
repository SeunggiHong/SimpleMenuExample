package com.example.simplemenuexample.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.models.repository.MyRepository
import com.example.simplemenuexample.utils.Constants.TAG
import kotlinx.coroutines.DelicateCoroutinesApi

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val myRepository: MyRepository = MyRepository(application)
    private val allUserList: LiveData<List<UserData>> = myRepository.getUserList()

    init {
        Log.d(TAG, "MainViewModel - () {$application}")
    }

    fun getAllUserList(): LiveData<List<UserData>> {
        Log.d(TAG, "MainViewModel - getAllUserList() called")
        return allUserList
    }

    @DelicateCoroutinesApi
    fun insertUser(user: UserData) {
        Log.d(TAG, "MainViewModel - insertUser() user = {$user}")
        myRepository.insertUser(user)
    }

}