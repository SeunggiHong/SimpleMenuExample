package com.example.simplemenuexample.views.subview

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.DialogBottomSheetBinding
import com.example.simplemenuexample.utils.Constants
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.views.PagerActivity
import com.example.simplemenuexample.views.SnackBarActivity
import com.example.simplemenuexample.views.UserActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomDialog: BottomSheetDialogFragment(), View.OnClickListener {
    private var _binding: DialogBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _binding = DataBindingUtil.inflate(inflater, R.layout.dialog_bottom_sheet, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRecycler.setOnClickListener(this)
        binding.tvSnack.setOnClickListener(this)
        binding.tvPopup.setOnClickListener(this)
        binding.tvViewpager.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.tvRecycler.id -> {
                val intent = Intent(activity, UserActivity::class.java)
                startActivity(intent)
            }
            binding.tvSnack.id -> {
                val intent = Intent(activity, SnackBarActivity::class.java)
                startActivity(intent)
            }
            binding.tvPopup.id -> {
                showUserAddDialog()
            }
            binding.tvViewpager.id -> {
                val intent = Intent(activity, PagerActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showUserAddDialog() {
        childFragmentManager.beginTransaction().replace(R.id.fragment_container, UserAddDialogFragment()).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "UserAddDialogFragment - onDestroyView() called")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CustomBottomDialog - onDestroy() called")
    }

}