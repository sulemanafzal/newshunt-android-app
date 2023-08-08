package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newshunt.R
import com.example.newshunt.adapter.AllNewsAdapter
import com.example.newshunt.adapter.AllNewsSliderAdapter
import com.example.newshunt.databinding.FragmentAllNewsBinding
import java.util.*

class AllNewsFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<AllNewsAdapter.ViewHolder>? = null
    lateinit var binding: FragmentAllNewsBinding
    private lateinit var allnewspagerslider: AllNewsSliderAdapter

    private var currentItem  =0
    private val imageList = listOf(
        R.drawable.heatwave,
        R.drawable.image_kalash,
        R.drawable.heatwave
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllNewsBinding.inflate(layoutInflater, container, false)

        layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager

        adapter = AllNewsAdapter()
        binding.recyclerView.adapter = adapter

        allnewspagerslider = AllNewsSliderAdapter(requireContext(), imageList)
        binding.sliderViewpager.adapter = allnewspagerslider

        val timer =Timer()

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                requireActivity().runOnUiThread {
                    if (currentItem == imageList.size) {
                        currentItem = 0
                    }
                    binding.sliderViewpager.currentItem = currentItem++
                }
            }
        }, 2000, 3000) // Auto-scroll every 3 seconds



        return binding.root
    }
}