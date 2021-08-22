package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.models.data.TestItem

class TestUserAdapter: RecyclerView.Adapter<TestUserItemViewHolder>(){
    var userTestList = mutableListOf<TestItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestUserItemViewHolder {
        val userTestItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent,false)
        return TestUserItemViewHolder(userTestItemViewHolder)
    }

    override fun onBindViewHolder(holder: TestUserItemViewHolder, position: Int) {
        this.userTestList[position]?.let { holder.bindViewHolder(it) }
    }

    override fun getItemCount(): Int {
        return userTestList.size
    }

    fun setTestItems(it: List<TestItem?>?) {
        this.userTestList = it!!.toMutableList()
        notifyDataSetChanged()
    }

}