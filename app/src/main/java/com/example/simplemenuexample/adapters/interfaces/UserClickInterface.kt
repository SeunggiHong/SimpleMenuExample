package com.example.simplemenuexample.adapters.interfaces

import com.example.simplemenuexample.models.data.UserData

interface UserClickInterface {
    fun onDeleteClicked(userData: UserData)
}