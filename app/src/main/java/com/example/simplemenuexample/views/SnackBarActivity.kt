package com.example.simplemenuexample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.TestUserAdapter
import com.example.simplemenuexample.databinding.ActivitySnackBarBinding
import com.example.simplemenuexample.models.data.TestItem
import com.example.simplemenuexample.utils.Constants
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.utils.CustomSnackBar
import com.example.simplemenuexample.utils.Status
import com.example.simplemenuexample.viewmodels.TestViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_snack_bar.*
import kotlinx.android.synthetic.main.activity_user_recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SnackBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySnackBarBinding
    private lateinit var userAdapter: TestUserAdapter
    private var arrayList: List<TestItem?>? = null
    private val testViewModel: TestViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SnackBarActivity - onCreate() called")
        title = resources.getString(R.string.title_snackbar_view)
        initView()
        initAdapter()

        binding.btnSnackBar.setOnClickListener {
            CustomSnackBar.make(binding.clLayout, Constants.SNACK_REQUEST, resources.getString(R.string.snack_start_get_api)).show()
            getTestUsers()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SnackBarActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SnackBarActivity - onResume() called")
    }

    private fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_snack_bar)
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        userAdapter = TestUserAdapter()
        rc_test_view.apply{
            layoutManager = LinearLayoutManager(this@SnackBarActivity, LinearLayoutManager.VERTICAL, false)
            adapter = userAdapter
        }
    }

    private fun getTestUsers() {
        testViewModel.getTestUsers().observe(this, Observer { response ->
            when(response?.status) {
                Status.SUCCESS -> {
                    Log.d(TAG, "SnackBarActivity - mainViewModel.getTestUsers() SUCCESS, ${response.data?.data}")

                    response.let {
                        arrayList = response.data?.data
                    }
                    userAdapter.setTestItems(arrayList)
                }

                Status.ERROR -> {
                    Log.d(TAG, "SnackBarActivity - mainViewModel.getTestUsers() ERROR!!! ${response.message}")
                    CustomSnackBar.make(binding.clLayout, Constants.SNACK_RETRY, resources.getString(R.string.snack_failed_get_api)).show()
                }

                Status.LOADING -> {
                    Log.d(TAG, "SnackBarActivity - mainViewModel.getTestUsers() LOADING")
                }
            }
        })
        testViewModel.fetchTestUsers()
    }



}