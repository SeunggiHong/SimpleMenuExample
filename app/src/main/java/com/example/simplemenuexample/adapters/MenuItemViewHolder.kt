package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.models.data.MenuData
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuItemViewHolder(itemView: View, clickInterface: ClickInterface): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val menuTitle = itemView.tv_title

    private var mClickInterface: ClickInterface? = null

    init{
        itemView.setOnClickListener(this)
        this.mClickInterface = clickInterface
    }

    fun bindViewHolder(menuData: MenuData) {
        menuTitle.text = menuData.name
    }

    override fun onClick(v: View?) {
        this.mClickInterface?.onMenuClicked(adapterPosition)
    }

}