package com.example.simplemenuexample.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.models.repository.MyRepository
import com.example.simplemenuexample.utils.Constants.TAG

class MainViewModel() : ViewModel() {
    private val myRepository: MyRepository = MyRepository()
    private val allMenuList = myRepository.getMenuList()


    init {

    }

    fun getAllMenuList() : ArrayList<MenuData>{
        return allMenuList
    }

    fun submitList() {

    }

}