package com.example.newshunt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newshunt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        // Set custom tab text
        binding.tabLayout.getTabAt(0)?.text = "All News"
        binding.tabLayout.getTabAt(1)?.text = "Sports"
        binding.tabLayout.getTabAt(2)?.text = "Technology"
        binding.tabLayout.getTabAt(3)?.text = "Politics"
    }
}



