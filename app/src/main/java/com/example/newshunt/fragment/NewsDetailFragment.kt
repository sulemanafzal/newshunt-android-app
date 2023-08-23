package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.databinding.FragmentNewsDetailBinding
import com.google.android.material.appbar.AppBarLayout

class NewsDetailFragment : Fragment() {

    lateinit var binding: FragmentNewsDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        val argu = arguments
        if (argu != null) {
            val title = argu.getString("title")
            val channelname = argu.getString("channelName")
            val desc = argu.getString("desc")
            val postDate = argu.getString("postDate")
            val imageResourceId = argu.getInt("image")
            val newslogo = argu.getInt("newsLogo")

     /*       val archlogo = argu.getInt("archLogo")
            val sharelogo = argu.getInt("shareLogo")
            */

            binding.cardTitlePolitcs.setText(title)
            binding.channelName.setText(channelname)
            binding.descDetilfragment.setText(desc)
            binding.dateDetail.setText(postDate)
           /* binding.shareLogoPolitcs.setImageResource(sharelogo)
            binding.archLogoPolitcs.setImageResource(archlogo)*/
            binding.topImage.setImageResource(imageResourceId)
            binding.channelLogoPolitcs.setImageResource(newslogo)

        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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