package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newshunt.ViewPagerAdapter
import com.example.newshunt.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)

        val adapter = ViewPagerAdapter(childFragmentManager) // Use childFragmentManager here


        binding.viewPager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        // Set custom tab text
        binding.tabLayout.getTabAt(0)?.text = "All News"
        binding.tabLayout.getTabAt(1)?.text = "Sports"
        binding.tabLayout.getTabAt(2)?.text = "Technology"
        binding.tabLayout.getTabAt(3)?.text = "Politics"
        // Set click listener for the hamburger_icon
        return binding.root // Return the root view of the binding
    }
}
