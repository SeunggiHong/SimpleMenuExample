package com.example.simplemenuexample.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.utils.Constants.TAG


class MenuAdapter(val menuList: ArrayList<MenuData>, clickInterface: ClickInterface) : RecyclerView.Adapter<MenuItemViewHolder>() {
    private var mClickInterface: ClickInterface? = null
    private var mMenuList: ArrayList<MenuData>

    init {
        this.mClickInterface = clickInterface
        this.mMenuList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val itemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuItemViewHolder(itemViewHolder, this.mClickInterface!!)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bindViewHolder(this.menuList[position])
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun submitMenuList(array: ArrayList<MenuData>) {
        this.mMenuList = menuList
        notifyDataSetChanged()
    }

}