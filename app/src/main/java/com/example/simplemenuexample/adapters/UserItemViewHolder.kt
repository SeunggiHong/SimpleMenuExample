package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.interfaces.UserClickInterface
import com.example.simplemenuexample.databinding.ItemUserBinding
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.utils.App

class UserItemViewHolder(binding: ItemUserBinding, clickInterface: UserClickInterface): RecyclerView.ViewHolder(binding.rootView) {
    private var mClickInterface: UserClickInterface? = null
    private val userImage = binding.ivUserPic
    private val userName = binding.tvUserName
    private val userEmail = binding.tvUserMail
    private val userPhone = binding.tvUserPhone
    private val userContent = binding.tvUserContent
    private val userBtnDel = binding.btnUserDelete

    init{
        this.mClickInterface = clickInterface
    }

    fun bindViewHolder(userData: UserData) {
        Glide.with(App.instance)
            .load(userData.userImage)
            .placeholder(R.drawable.ic_default_user)
            .into(userImage)
        userName.text = userData.userName
        userEmail.text = userData.userEmail
        userPhone.text = userData.userPhone
        userContent.text = userData.userContent

        userBtnDel.setOnClickListener {
            mClickInterface?.onDeleteClicked(userData)
        }
    }

}