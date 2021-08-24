package com.example.simplemenuexample.utils

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.ItemSnackbarBinding
import com.example.simplemenuexample.viewmodels.TestViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CustomSnackBar(view: View, private val type: Int, private val message: String): KoinComponent {

    companion object {
        fun make(view: View, type: Int, message: String) = CustomSnackBar(view, type, message)
    }

    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 4000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val binding: ItemSnackbarBinding = DataBindingUtil.inflate(inflater, R.layout.item_snackbar, null, false)
    private val testViewModel: TestViewModel by inject()

    init {
        initView()
        initData()
    }

    private fun initView() {
        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(binding.root, 0)
        }
    }

    private fun initData() {
        binding.tvMsg.text = message

        when(type) {
            Constants.SNACK_REQUEST -> {
                binding.btnSnack.visibility = View.INVISIBLE
            }
            Constants.SNACK_RETRY -> {
                binding.btnSnack.visibility = View.VISIBLE
            }
            else -> {
                binding.btnSnack.visibility = View.VISIBLE
            }
        }

        binding.btnSnack.setOnClickListener {
            when(type) {
                Constants.SNACK_RETRY -> {
                    testViewModel.fetchTestUsers()
                }
            }

        }
    }

    fun show() {
        snackbar.show()
    }

}