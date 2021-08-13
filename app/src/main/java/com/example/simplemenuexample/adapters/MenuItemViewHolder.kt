package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.models.data.MenuData
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val menuTitle = itemView.tv_title

    fun bindViewHolder(menuData: MenuData) {
        menuTitle.text = menuData.name
    }

}