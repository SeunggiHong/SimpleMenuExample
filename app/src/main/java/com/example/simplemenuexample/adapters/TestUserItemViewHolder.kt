package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.models.data.TestItem
import com.example.simplemenuexample.utils.App
import kotlinx.android.synthetic.main.item_user.view.*

class TestUserItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val userImage = itemView.iv_user_pic
    private val userName = itemView.tv_user_name
    private val userEmail = itemView.tv_user_mail
    private val userPhone = itemView.tv_user_phone
    private val userContent = itemView.tv_user_content
    private val userDelete = itemView.btn_user_delete

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