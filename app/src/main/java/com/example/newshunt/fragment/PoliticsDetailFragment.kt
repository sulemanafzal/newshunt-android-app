package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.databinding.FragmentPoliticsDetailBinding

class PoliticsDetailFragment : Fragment() {

    lateinit var binding:FragmentPoliticsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPoliticsDetailBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}