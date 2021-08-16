package com.example.simplemenuexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.UserAdapter
import com.example.simplemenuexample.databinding.ActivityUserRecyclerViewBinding
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_user_recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserRecyclerViewBinding
    private lateinit var userAdapter: UserAdapter
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.title_recycler_view)
        initView()
        initAdapater()
        initViewModel()

        Log.d(TAG, "UserRecyclerViewActivity - onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "UserRecyclerViewActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "UserRecyclerViewActivity - onResume() called")
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_recycler_view)
        binding.lifecycleOwner = this
    }

    private fun initAdapater() {
        userAdapter = UserAdapter()
        rc_user_view.apply{
            layoutManager = LinearLayoutManager(this@UserRecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = userAdapter
        }
    }

    private fun initViewModel() {

    }

}