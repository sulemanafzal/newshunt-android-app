package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.activity.MainActivity
import com.example.newshunt.adapter.TempAdapter
import com.example.newshunt.adapter.ViewPagerAdapter
import com.example.newshunt.databinding.FragmentNewsBinding
import com.google.android.material.tabs.TabLayoutMediator

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)

        //val adapter = ViewPagerAdapter(childFragmentManager) // Use childFragmentManager here

        /*   binding.viewPager.adapter = adapter

         binding.tabLayout.setupWithViewPager(binding.viewPager)

         // Set custom tab text
         binding.tabLayout.getTabAt(0)?.text = "All News"
         binding.tabLayout.getTabAt(1)?.text = "Sports"
         binding.tabLayout.getTabAt(2)?.text = "Technology"
         binding.tabLayout.getTabAt(3)?.text = "Politics"
         // Set click listener for the hamburger_icon
 */
        binding.humblerIcon.setOnClickListener {
            val mainActivity = requireActivity() as MainActivity
            val drawerLayout = mainActivity.findViewById<DrawerLayout>(R.id.drawer_layout)
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tempAdapter = TempAdapter(requireActivity())

        tempAdapter.addFragment(AllNewsFragment(), "All News")
        tempAdapter.addFragment(PoliticsFragment(), "Politics")
        tempAdapter.addFragment(SportsFragment(), "Sports")
        tempAdapter.addFragment(TechnologyFragment(), "Technology")

        binding.viewPager2.adapter = tempAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = tempAdapter.getTitle(position)
        }.attach()
        }
}