package com.example.simplemenuexample.views.subview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplemenuexample.adapters.UserPageAdapter
import com.example.simplemenuexample.databinding.FragmentUserPageBinding
import com.example.simplemenuexample.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserPageBinding
    private lateinit var userAdapter: UserPageAdapter
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPageBinding.inflate(inflater, container, false)
        context ?: return binding.root

        initAdapter()
        initViewModel()

        return binding.root
    }

    private fun initAdapter() {
        userAdapter = UserPageAdapter()
        binding.userList.adapter = userAdapter
    }

    private fun initViewModel() {
        viewModel.getAllUserList().observe( viewLifecycleOwner, { userlist ->
            userAdapter.setItems(userlist)
        })
    }

}