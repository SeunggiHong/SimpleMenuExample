package com.example.simplemenuexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.repository.MyRepository

class MainViewModel() : ViewModel() {

    private val myRepository: MyRepository = MyRepository()

    private val allMenuList = myRepository.getMenuList()

    fun getAllMenuList() : ArrayList<MenuData>{
        return allMenuList
    }

}