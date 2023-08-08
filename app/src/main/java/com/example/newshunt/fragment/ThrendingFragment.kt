package com.example.newshunt.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.activity.MainActivity
import com.example.newshunt.databinding.FragmentThrendingBinding

class ThrendingFragment : Fragment() {
    lateinit var binding: FragmentThrendingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThrendingBinding.inflate(layoutInflater, container, false)

        binding.humblerIcon.setOnClickListener {
            val mainActivity = requireActivity() as MainActivity
            val drawerLayout = mainActivity.findViewById<DrawerLayout>(R.id.drawer_layout)
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return binding.root
    }
}