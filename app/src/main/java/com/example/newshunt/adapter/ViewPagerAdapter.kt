package com.example.newshunt.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newshunt.fragment.AllNewsFragment
import com.example.newshunt.fragment.PoliticsFragment
import com.example.newshunt.fragment.SportsFragment
import com.example.newshunt.fragment.TechnologyFragment

@Suppress("DEPRECATION")
class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 4 // The number of fragments you want to display
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllNewsFragment()
            1 -> SportsFragment()
            2 -> TechnologyFragment()
            3 -> PoliticsFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}