package com.example.simplemenuexample.models.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.models.db.UserDao
import com.example.simplemenuexample.models.db.UserDatabase
import com.example.simplemenuexample.utils.Constants.TAG
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    @DelicateCoroutinesApi
    fun insertUser(user: UserData) {
        GlobalScope.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    @DelicateCoroutinesApi
    fun deleteUser(user: UserData) {
        GlobalScope.launch(Dispatchers.IO) {
            userDao.delete(user)
        }
    }

}