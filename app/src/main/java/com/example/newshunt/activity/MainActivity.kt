package com.example.newshunt.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newshunt.R
import com.example.newshunt.databinding.ActivityMainBinding
import com.example.newshunt.fragment.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(NewsFragment())


  /*       val NavController = findNavController(R.id.fragmentContainerView)
         binding.bottonMenu.setupWithNavController(NavController)


*/



        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.close,
            R.string.open
        )
        binding.toolbar.visibility = View.GONE
        replaceFragment(NewsFragment())

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.news_selection) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
                binding.toolbar.setVisibility(View.GONE)
                replaceFragment(NewsFragment())
            } else if (item.itemId == R.id.opinions) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
                binding.toolbar.setVisibility(View.GONE)
                replaceFragment(OpinionFragment())
            } else if (item.itemId == R.id.category) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
                binding.toolbar.setVisibility(View.GONE)
                replaceFragment(CategoryFragment())
            } else if (item.itemId == R.id.language) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
                binding.toolbar.setVisibility(View.GONE)
                replaceFragment(LanguageFragment())
            }
            false
        })

        binding.bottonMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.newsFragment -> replaceFragment(NewsFragment())
                R.id.opinionFragment -> replaceFragment(OpinionFragment())
                R.id.threndingFragment -> replaceFragment(ThrendingFragment())
                R.id.archFragment -> replaceFragment(ArchFragment())
            }
            true
        }

        // Initially replace with NewsFragment
        replaceFragment(NewsFragment())
    }

private fun replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.framelayout, fragment)
        .commit()

    }
}



