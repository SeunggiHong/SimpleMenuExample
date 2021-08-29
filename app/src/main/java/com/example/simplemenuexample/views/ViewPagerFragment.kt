package com.example.simplemenuexample.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplemenuexample.R
import com.example.simplemenuexample.adapters.ViewPagerAdapter
import com.example.simplemenuexample.databinding.FragmentViewPagerBinding
import com.example.simplemenuexample.utils.Page.DETAIL_PAGE_INDEX
import com.example.simplemenuexample.utils.Page.USER_PAGE_INDEX
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            USER_PAGE_INDEX -> R.drawable.ic_baseline_contact_page_24
            DETAIL_PAGE_INDEX -> R.drawable.ic_baseline_cookie_24
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            USER_PAGE_INDEX -> getString(R.string.page_user_title)
            DETAIL_PAGE_INDEX -> getString(R.string.page_user_detail_title)
            else -> null
        }
    }

}