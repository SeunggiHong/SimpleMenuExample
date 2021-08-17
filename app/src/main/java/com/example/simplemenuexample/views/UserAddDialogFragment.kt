package com.example.simplemenuexample.views

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.DialogUserAddBinding

import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserAddDialogFragment : DialogFragment() {
    private val viewModel: MainViewModel by viewModel()
    private var _binding: DialogUserAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "UserAddDialogFragment - onCreate() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "UserAddDialogFragment - onResume() called")
        setWidthPercent(85)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogUserAddBinding.inflate(inflater, container, false)
        Log.d(TAG, "UserAddDialogFragment - onCreateView() called")

        val view = binding.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btnClose.setOnClickListener {
            dismiss()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "UserAddDialogFragment - onDestroyView() called")
        _binding = null
    }

    fun DialogFragment.setWidthPercent(percentage: Int) {
        val percent = percentage.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * percent
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}