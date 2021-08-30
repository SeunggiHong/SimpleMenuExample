package com.example.simplemenuexample.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.adapters.interfaces.MenuClickInterface
import com.example.simplemenuexample.databinding.ItemMenuBinding
import com.example.simplemenuexample.models.data.MenuData

class MenuItemViewHolder(binding: ItemMenuBinding, clickInterface: MenuClickInterface): RecyclerView.ViewHolder(binding.cardView), View.OnClickListener {
    private val menuTitle = binding.tvTitle
    private var mClickInterface: MenuClickInterface? = null

    init{
        itemView.rootView.setOnClickListener(this)
        this.mClickInterface = clickInterface
    }

    fun bindViewHolder(menuData: MenuData) {
        menuTitle.text = menuData.name
    }

    override fun onClick(v: View?) {
        this.mClickInterface?.onMenuClicked(adapterPosition)
    }

}