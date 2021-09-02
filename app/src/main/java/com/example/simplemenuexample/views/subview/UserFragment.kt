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
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPageBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = UserPageAdapter()
        binding.userList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: UserPageAdapter) {
        viewModel.getAllUserList().observe(viewLifecycleOwner) { users ->
            adapter.submitList(users)
        }

    }

}