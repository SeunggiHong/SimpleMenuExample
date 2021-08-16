package com.example.simplemenuexample.adapters

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R

class UserAdapter(): RecyclerView.Adapter<UserItemViewHolder>() {

    var _userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val userItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent,false)
        return UserItemViewHolder(userItemViewHolder)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return _userList.size
    }




}