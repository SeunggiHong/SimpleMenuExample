package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.ItemUserPageBinding
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.utils.App

class UserPageAdapter() : RecyclerView.Adapter<UserPageAdapter.UserViewHolder>() {
    var userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindViewHolder(this.userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(
        private val binding: ItemUserPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindViewHolder(userData: UserData) {
            Glide.with(App.instance)
                .load(userData.userImage)
                .placeholder(R.drawable.ic_default_user)
                .into(binding.ivUserPic)
            binding.tvUserName.text = userData.userName
        }

    }

    fun setItems(it: List<UserData>) {
        this.userList = it.toMutableList()
        notifyDataSetChanged()
    }

}