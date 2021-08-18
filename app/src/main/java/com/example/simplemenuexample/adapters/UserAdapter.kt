package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.interfaces.MenuClickInterface
import com.example.simplemenuexample.adapters.interfaces.UserClickInterface
import com.example.simplemenuexample.models.data.UserData

class UserAdapter(clickInterface: UserClickInterface): RecyclerView.Adapter<UserItemViewHolder>() {
    private var mClickInterface: UserClickInterface? = null
    var userList = mutableListOf<UserData>()

    init {
        this.mClickInterface = clickInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val userItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent,false)
        return UserItemViewHolder(userItemViewHolder, this.mClickInterface!!)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bindViewHolder(this.userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setItems(it: List<UserData>) {
        this.userList = it.toMutableList()
        notifyDataSetChanged()
    }

}