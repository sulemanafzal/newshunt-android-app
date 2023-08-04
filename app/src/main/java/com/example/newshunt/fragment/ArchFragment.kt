package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.databinding.FragmentArchBinding
import com.example.newshunt.databinding.FragmentNewsBinding
import com.google.android.material.appbar.AppBarLayout

class ArchFragment : Fragment() {
    lateinit var binding: FragmentArchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArchBinding.inflate(layoutInflater, container, false)

        return binding.root

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