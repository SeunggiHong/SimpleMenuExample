package com.example.simplemenuexample.models.repository

import androidx.lifecycle.LiveData
import com.example.simplemenuexample.models.data.MenuData

class MyRepository() {

    private var allMenuList: ArrayList<MenuData> = ArrayList()

    init {
        allMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))

    }

    fun getMenuList():ArrayList<MenuData> {
        return allMenuList
    }


}