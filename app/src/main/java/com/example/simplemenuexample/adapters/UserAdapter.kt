package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.models.data.UserData

class UserAdapter(): RecyclerView.Adapter<UserItemViewHolder>() {

    var userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val userItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent,false)
        return UserItemViewHolder(userItemViewHolder)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bindViewHolder(this.userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}