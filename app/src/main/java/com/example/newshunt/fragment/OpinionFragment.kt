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
import com.example.newshunt.adapter.ViewPagerAdapter
import com.example.newshunt.databinding.FragmentOpinionBinding

class OpinionFragment : Fragment() {
    lateinit var binding: FragmentOpinionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOpinionBinding.inflate(layoutInflater, container, false)
        val adapter = ViewPagerAdapter(childFragmentManager) // Use childFragmentManager here


        binding.viewPager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        // Set custom tab text
        binding.tabLayout.getTabAt(0)?.text = "Hasan Nisar"
        binding.tabLayout.getTabAt(1)?.text = "Hamid Mir"
        binding.tabLayout.getTabAt(2)?.text = "Iqrar Ul Hassan"
        binding.tabLayout.getTabAt(3)?.text = "Aftab Iqbal"
        binding.humblerIcon.setOnClickListener {
            val mainActivity = requireActivity() as MainActivity
            val drawerLayout = mainActivity.findViewById<DrawerLayout>(R.id.drawer_layout)
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return binding.root
    }
}