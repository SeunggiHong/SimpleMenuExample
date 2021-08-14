package com.example.simplemenuexample.models.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.utils.Constants.TAG

class MyRepository() {

    private var allMenuList: ArrayList<MenuData> = ArrayList()

    init {
        allMenuList.add(MenuData("RecyclerView", "RecyclerView"))
        allMenuList.add(MenuData("SnackBar", "SnackBarView"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
    }

    fun getMenuList():ArrayList<MenuData> {
        return allMenuList
    }


}