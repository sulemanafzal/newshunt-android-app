package com.example.newshunt.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newshunt.fragment.BrowseFragment
import com.example.newshunt.fragment.FollowingFragment

class OpinionSelectionSlideAdapter(
    fragment: Fragment,
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> FollowingFragment()
            1 -> BrowseFragment()

            else -> throw java.lang.IllegalArgumentException(" Invalid Position")
        }
    }
}