package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.ItemUserBinding
import com.example.simplemenuexample.models.data.TestItem
import com.example.simplemenuexample.utils.App

class TestUserItemViewHolder(binding: ItemUserBinding): RecyclerView.ViewHolder(binding.rootView) {
    private val userImage = binding.ivUserPic
    private val userName = binding.tvUserName
    private val userEmail = binding.tvUserMail
    private val userPhone = binding.tvUserPhone
    private val userContent = binding.tvUserContent
    private val userDelete = binding.btnUserDelete

    fun bindViewHolder(userData: TestItem) {
        Glide.with(App.instance)
            .load(userData.user_image)
            .placeholder(R.drawable.ic_default_user)
            .into(userImage)
        userName.text = userData.user_name
        userEmail.text = userData.user_email
        userPhone.text = userData.user_phone
        userContent.text = userData.user_content

        userDelete.visibility = View.GONE
    }

}