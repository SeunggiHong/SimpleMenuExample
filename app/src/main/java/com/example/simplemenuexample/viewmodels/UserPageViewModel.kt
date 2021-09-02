package com.example.simplemenuexample.viewmodels

import com.example.simplemenuexample.models.data.UserData

class UserPageViewModel(users: UserData) {

    private val user = checkNotNull(users)

    val userName
        get() = user.userName

    val userPhone
        get() = user.userPhone

    val userEmail
        get() = user.userEmail

    val userContent
        get() = user.userContent

    val userImage
        get()= user.userImage

}