package com.example.simplemenuexample.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.models.data.MenuData
import com.example.simplemenuexample.utils.Constants.TAG


class MenuAdapter(clickInterface: ClickInterface) : RecyclerView.Adapter<MenuItemViewHolder>() {
    private var mClickInterface: ClickInterface? = null
    private var mMenuList: ArrayList<MenuData>

    init {
        this.mClickInterface = clickInterface
        this.mMenuList = ArrayList()
        initMenuData()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val itemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuItemViewHolder(itemViewHolder, this.mClickInterface!!)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bindViewHolder(this.mMenuList[position])
    }

    override fun getItemCount(): Int {
        return mMenuList.size
    }

    private fun initMenuData() {
        mMenuList.add(MenuData("RecyclerView", "RecyclerView"))
        mMenuList.add(MenuData("SnackBar", "SnackBarView"))
        mMenuList.add(MenuData("Popup Dialog", "Popup DialogView"))
        mMenuList.add(MenuData("BottomSheetDialog", "BottomSheetDialog"))
        mMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        mMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        mMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
    }

}