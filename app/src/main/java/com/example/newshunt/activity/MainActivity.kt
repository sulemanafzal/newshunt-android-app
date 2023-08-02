package com.example.newshunt.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newshunt.R
import com.example.newshunt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        binding.hamburgerIcon.setOnClickListener {
            val mainActivity = requireActivity() as MainActivity
            val drawerLayout = mainActivity.findViewById<DrawerLayout>(R.id.drawer_layout)
            drawerLayout!!.openDrawer(GravityCompat.START)
        }*/


        val NavController = findNavController(R.id.fragmentContainerView)
        binding.bottomNav.setupWithNavController(NavController)


    }
}



