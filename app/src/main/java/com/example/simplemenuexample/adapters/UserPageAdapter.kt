package com.example.simplemenuexample.adapters

import android.annotation.SuppressLint
import android.os.Build

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.databinding.ItemUserPageBinding
import com.example.simplemenuexample.models.data.UserData

class UserPageAdapter() : ListAdapter<UserData, RecyclerView.ViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            ItemUserPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = getItem(position)
        (holder as UserViewHolder).bind(user)
    }

    class UserViewHolder(
        private val binding: ItemUserPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserData) {
            binding.apply {
                user = item
                executePendingBindings()
            }
        }
    }

}

private class UserDiffCallback: DiffUtil.ItemCallback<UserData>() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem == newItem
    }
}