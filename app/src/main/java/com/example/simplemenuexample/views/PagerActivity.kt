package com.example.simplemenuexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.ActivityPagerBinding
import com.example.simplemenuexample.utils.Constants.TAG

class PagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "PagerActivity - onCreate() called")
        initView()
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pager)
        binding.lifecycleOwner = this
    }
}