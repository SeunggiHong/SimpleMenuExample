package com.example.simplemenuexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.UserAdapter
import com.example.simplemenuexample.adapters.interfaces.UserClickInterface
import com.example.simplemenuexample.databinding.ActivityUserRecyclerViewBinding
import com.example.simplemenuexample.models.data.UserData
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_user_recycler_view.*
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserActivity : AppCompatActivity(), UserClickInterface {
    private lateinit var binding: ActivityUserRecyclerViewBinding
    private lateinit var userAdapter: UserAdapter
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "UserActivity - onCreate() called")
        title = resources.getString(R.string.title_recycler_view)
        initView()
        initAdapter()
        initViewModel()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "UserActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "UserActivity - onResume() called")
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_recycler_view)
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        userAdapter = UserAdapter(this)
        rc_user_view.apply{
            layoutManager = LinearLayoutManager(this@UserActivity, LinearLayoutManager.VERTICAL, false)
            adapter = userAdapter
        }
    }

    private fun initViewModel() {
        mainViewModel.getAllUserList().observe(this, { userlist ->
            userAdapter.setItems(userlist)
        })
    }

    @DelicateCoroutinesApi
    override fun onDeleteClicked(userData: UserData) {
        mainViewModel.deleteUser(userData)
        Toast.makeText(this, R.string.toast_user_delete, Toast.LENGTH_SHORT).show()
    }

}