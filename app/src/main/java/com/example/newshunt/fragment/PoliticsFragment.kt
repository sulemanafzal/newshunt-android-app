package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newshunt.R
import com.example.newshunt.adapter.AllNewsAdapter
import com.example.newshunt.adapter.AllNewsSliderAdapter
import com.example.newshunt.databinding.FragmentPoliticsBinding
import java.util.*

class PoliticsFragment : Fragment() {

    lateinit var binding: FragmentPoliticsBinding

    private var currentItem = 0
    private val imageList = listOf(
        R.drawable.shahabazsharip,
        R.drawable.heatwave,
        R.drawable.image_kalash
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPoliticsBinding.inflate(layoutInflater, container, false)
        var layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
       val politicsnews = AllNewsAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = politicsnews
        }
        val allnewspagerslider = AllNewsSliderAdapter(requireContext(), imageList)
        binding.sliderViewpager.adapter = allnewspagerslider
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                requireActivity().runOnUiThread {
                    if (currentItem == imageList.size) {
                        currentItem = 0
                    }
                    binding.sliderViewpager.currentItem = currentItem++
                }
            }
        }, 2000, 3000)
        return binding.root
    }
}