package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newshunt.Model.OSFollowingItem
import com.example.newshunt.R
import com.example.newshunt.adapter.OSFollowingAdapter
import com.example.newshunt.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {
    lateinit var binding: FragmentFollowingBinding
    lateinit var rvadapter: OSFollowingAdapter
    lateinit var dataList: ArrayList<OSFollowingItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(layoutInflater, container, false)
        return binding.root

        dataList =ArrayList<OSFollowingItem>()

        dataList.add(
            OSFollowingItem(
                R.drawable.hassannisar_image,
                R.drawable.exit_logo,
                "Hassan Nasir",
                "Pakistan, Asia"
            )
        )
        dataList.add(
            OSFollowingItem(
                R.drawable.hamidmir_image,
                R.drawable.exit_logo,
                "Hamid Mir",
                "Pakistan, Asia"
            )
        )
        dataList.add(
            OSFollowingItem(
                R.drawable.javed_iqbal,
                R.drawable.exit_logo,
                "Javed Iqbal",
                "Pakistan, Asia"
            )
        )

        rvadapter = OSFollowingAdapter(
            dataList,
            requireContext()
        ) // Replace with your adapter instantiation
        binding.recyclerViewFollowing.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rvadapter
        }

    }
}