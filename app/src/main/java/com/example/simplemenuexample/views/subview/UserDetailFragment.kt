package com.example.simplemenuexample.views.subview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplemenuexample.adapters.UserDetailPageAdapter
import com.example.simplemenuexample.adapters.UserPageAdapter
import com.example.simplemenuexample.databinding.FragmentUserDetailPageBinding
import com.example.simplemenuexample.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailPageBinding
    private lateinit var userAdapter: UserDetailPageAdapter
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailPageBinding.inflate(inflater, container, false)
        context ?: return binding.root

        initAdapter()
        initViewModel()

        return binding.root
    }

    private fun initAdapter() {
        userAdapter = UserDetailPageAdapter()
        binding.userDetailList.adapter = userAdapter
    }

    private fun initViewModel() {
        viewModel.getAllUserList().observe( viewLifecycleOwner, { userlist ->
            userAdapter.setItems(userlist)
        })
    }

}