package com.example.newshunt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.newshunt.R
import com.example.newshunt.databinding.FragmentArchBinding
import com.example.newshunt.databinding.FragmentSportsBinding
import com.google.android.material.appbar.AppBarLayout

@Suppress("NAME_SHADOWING")
class SportsFragment : Fragment() {

    lateinit var binding: FragmentSportsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}