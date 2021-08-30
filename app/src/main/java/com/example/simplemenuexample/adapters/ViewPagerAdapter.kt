package com.example.simplemenuexample.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simplemenuexample.utils.Page.DETAIL_PAGE_INDEX
import com.example.simplemenuexample.utils.Page.USER_PAGE_INDEX
import com.example.simplemenuexample.views.subview.UserDetailFragment
import com.example.simplemenuexample.views.subview.UserFragment
import java.lang.IndexOutOfBoundsException

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        USER_PAGE_INDEX to { UserFragment() },
        DETAIL_PAGE_INDEX to { UserDetailFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}