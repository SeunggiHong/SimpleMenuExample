package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.models.data.MenuData


class MenuAdapter : RecyclerView.Adapter<MenuItemViewHolder>() {
    private var menuList = mutableListOf<MenuData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val itemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuItemViewHolder(itemViewHolder)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bindViewHolder(this.menuList[position])
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun setItems(it: List<MenuData>) {
        this.menuList = it.toMutableList()
        notifyDataSetChanged()
    }

}