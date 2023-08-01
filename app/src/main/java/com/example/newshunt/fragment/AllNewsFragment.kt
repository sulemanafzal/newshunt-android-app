package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newshunt.AllNewsItem
import com.example.newshunt.adapter.AllNewsAdapter
import com.example.newshunt.databinding.FragmentAllNewsBinding

class AllNewsFragment : Fragment() {

    lateinit var binding: FragmentAllNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllNewsBinding.inflate(layoutInflater, container, false)




// Create a list of NewsItem objects
        val newsList: List<AllNewsItem> = mutableListOf() // Add your NewsItem objects to this list

// Create the adapter and set it to the RecyclerView
        val newsAdapter = AllNewsAdapter(newsList)
        binding.recyclerView.adapter = newsAdapter

        return binding.root
    }
}