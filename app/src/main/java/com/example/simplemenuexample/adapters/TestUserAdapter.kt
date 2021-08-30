package com.example.simplemenuexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.ItemUserBinding
import com.example.simplemenuexample.models.data.TestItem

class TestUserAdapter: RecyclerView.Adapter<TestUserItemViewHolder>(){
    var userTestList = mutableListOf<TestItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestUserItemViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestUserItemViewHolder(binding)
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