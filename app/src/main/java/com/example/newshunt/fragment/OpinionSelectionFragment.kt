package com.example.newshunt.fragment

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.newshunt.Model.OSFollowingItem
import com.example.newshunt.R
import com.example.newshunt.adapter.OSFollowingAdapter
import com.example.newshunt.adapter.OpinionSelectionSlideAdapter
import com.example.newshunt.databinding.FragmentOpinionSelectionBinding

class OpinionSelectionFragment : Fragment() {
    lateinit var binding: FragmentOpinionSelectionBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOpinionSelectionBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFollowing.setOnClickListener {
            binding.viewPager.currentItem = 0
            /*         binding.btnFollowing.backgroundTintList =
                         ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
                     binding.btnFollowing.backgroundTintList =
                         ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.blue))
              */   }
        binding.btnBrowse.setOnClickListener {
            binding.viewPager.currentItem = 1

        }

        val pagerAdapter = OpinionSelectionSlideAdapter(this, childFragmentManager, lifecycle)
        binding.viewPager.adapter = pagerAdapter

    }
}