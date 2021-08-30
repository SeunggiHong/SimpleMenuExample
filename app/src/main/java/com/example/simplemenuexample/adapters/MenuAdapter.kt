package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.interfaces.MenuClickInterface
import com.example.simplemenuexample.databinding.ItemMenuBinding
import com.example.simplemenuexample.models.data.MenuData


class MenuAdapter(clickInterface: MenuClickInterface) : RecyclerView.Adapter<MenuItemViewHolder>() {
    private var mClickInterface: MenuClickInterface? = null
    private var mMenuList: ArrayList<MenuData>

    init {
        this.mClickInterface = clickInterface
        this.mMenuList = ArrayList()
        initMenuData()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuItemViewHolder(binding, this.mClickInterface!!)
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
        mMenuList.add(MenuData("ViewPager", "ViewPager2"))
        mMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
        mMenuList.add(MenuData("seunggiHong", "tmdrl1026@naver.com"))
    }

}