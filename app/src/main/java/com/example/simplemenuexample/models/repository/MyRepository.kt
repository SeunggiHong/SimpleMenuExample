package com.example.simplemenuexample.models.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.models.db.UserDao
import com.example.simplemenuexample.models.db.UserDatabase

class MyRepository(application: Application) {
    private val userDao: UserDao
    private var allMenuList: ArrayList<MenuData> = ArrayList()
    private val _allUserList: LiveData<List<UserData>>

    init {
        initMenuData()
        val database = UserDatabase.getInstance(application.applicationContext)
        userDao = database!!.userDao()

        _allUserList = userDao.getAllUserList()
    }

    fun getMenuList():ArrayList<MenuData> {
        return this.allMenuList
    }

    fun getUserList(): LiveData<List<UserData>> {
        return this._allUserList
    }


    private fun initMenuData() {
        allMenuList.add(MenuData("RecyclerView", "RecyclerView"))
        allMenuList.add(MenuData("SnackBar", "SnackBarView"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
    }

}