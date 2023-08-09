package com.example.newshunt.adapter


import com.example.newshunt.fragment.AllNewsFragment
import com.example.newshunt.fragment.PoliticsFragment
import com.example.newshunt.fragment.SportsFragment
import com.example.newshunt.fragment.TechnologyFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class ViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mFragmentList : ArrayList<Fragment> = ArrayList()

    fun addFragment(fragment: Fragment){
        mFragmentList.add(fragment)
    }
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllNewsFragment()
            1 -> SportsFragment()
            2 -> TechnologyFragment()
            3 -> PoliticsFragment()

            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun getCount(): Int {
        return 4
    }
}