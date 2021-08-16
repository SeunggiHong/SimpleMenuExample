package com.example.simplemenuexample.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.models.repository.MyRepository
import com.example.simplemenuexample.utils.Constants.TAG

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val myRepository: MyRepository = MyRepository(application)
    private val allMenuList = myRepository.getMenuList()
    private val _allUserList = myRepository.getUserList()

    fun getAllMenuList(): ArrayList<MenuData>{
        return allMenuList
    }

    fun getAllUserList(): LiveData<List<UserData>> {
        Log.d(TAG, "MainViewModel - getAllUserList() called")
        return _allUserList
    }

}