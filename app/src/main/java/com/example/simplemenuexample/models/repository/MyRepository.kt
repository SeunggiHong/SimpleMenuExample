package com.example.simplemenuexample.models.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.models.db.UserDao
import com.example.simplemenuexample.models.db.UserDatabase
import com.example.simplemenuexample.utils.Constants.TAG

class MyRepository(application: Application) {

    private val userDao: UserDao
    private val _allUserList: LiveData<List<UserData>>

    init {
        Log.d(TAG, "MyRepository init")

        val database = UserDatabase.getInstance(application.applicationContext)
        userDao = database!!.userDao()
        _allUserList = userDao.getAllUserList()
    }

    fun getUserList(): LiveData<List<UserData>> {
        return this._allUserList
    }

}