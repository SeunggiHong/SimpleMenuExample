package com.example.simplemenuexample.adapters

import android.annotation.SuppressLint
import android.os.Build

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.ItemUserDetailPageBinding
import com.example.simplemenuexample.databinding.ItemUserPageBinding
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.utils.App

class UserDetailPageAdapter() : RecyclerView.Adapter<UserDetailPageAdapter.UserViewHolder>() {
    var userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserDetailPageBinding.inflate(
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
        private val binding: ItemUserDetailPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindViewHolder(userData: UserData) {
            Glide.with(App.instance)
                .load(userData.userImage)
                .placeholder(R.drawable.ic_default_user)
                .into(binding.ivDetail)
            binding.tvDetailName.text = userData.userName
            binding.tvDetailEmail.text = userData.userEmail
            binding.tvDetailPhone.text = userData.userPhone
            binding.tvDetailContent.text = userData.userContent
        }

    }

    fun setItems(it: List<UserData>) {
        this.userList = it.toMutableList()
        notifyDataSetChanged()
    }

}