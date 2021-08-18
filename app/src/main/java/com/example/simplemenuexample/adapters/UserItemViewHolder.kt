package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.interfaces.MenuClickInterface
import com.example.simplemenuexample.adapters.interfaces.UserClickInterface
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.utils.App
import kotlinx.android.synthetic.main.item_user.view.*

class UserItemViewHolder(itemView: View, clickInterface: UserClickInterface): RecyclerView.ViewHolder(itemView) {
    private var mClickInterface: UserClickInterface? = null
    private val userImage = itemView.iv_user_pic
    private val userName = itemView.tv_user_name
    private val userEmail = itemView.tv_user_mail
    private val userPhone = itemView.tv_user_phone
    private val userContent = itemView.tv_user_content
    private val userBtnDel = itemView.btn_user_delete

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