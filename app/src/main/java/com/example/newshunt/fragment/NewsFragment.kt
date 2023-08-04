package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.adapter.ViewPagerAdapter
import com.example.newshunt.databinding.FragmentNewsBinding
import com.google.android.material.appbar.AppBarLayout

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)

        val adapter = ViewPagerAdapter(childFragmentManager) // Use childFragmentManager here


        /*  binding.viewPager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        // Set custom tab text
        binding.tabLayout.getTabAt(0)?.text = "All News"
        binding.tabLayout.getTabAt(1)?.text = "Sports"
        binding.tabLayout.getTabAt(2)?.text = "Technology"
        binding.tabLayout.getTabAt(3)?.text = "Politics"*/
        // Set click listener for the hamburger_icon
        return binding.root // Return the root view of the binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val collapsingToolbarLayout = binding.collapsingToolbarLayout
        val appBarLayout = binding.appBarLayout
        val toolbarImageView = binding.toolbarbackImage
        val toolbarTextView = binding.toolbarTV

        // Set the initial toolbar icon and text color here if needed
        toolbarImageView.setImageResource(R.drawable.back_icon_white)
        toolbarTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxScroll = appBarLayout.totalScrollRange
            val percentage = Math.abs(verticalOffset).toFloat() / maxScroll.toFloat()

            val iconRes =
                if (percentage >= 0.8) R.drawable.back_icon else R.drawable.back_icon_white
            val textColorRes = if (percentage >= 0.8) R.color.black else R.color.white

            toolbarImageView.setImageResource(iconRes)
            toolbarTextView.setTextColor(ContextCompat.getColor(requireContext(), textColorRes))
        })

    }
}