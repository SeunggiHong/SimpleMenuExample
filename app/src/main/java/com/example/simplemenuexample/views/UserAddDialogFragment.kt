package com.example.simplemenuexample.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.simplemenuexample.R
import com.example.simplemenuexample.databinding.FragmentUserAddDialogBinding
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserAddDialogFragment : DialogFragment() {
    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentUserAddDialogBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "UserAddDialogFragment - onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserAddDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d(TAG, "UserAddDialogFragment - onDestroyView() called")
    }

}