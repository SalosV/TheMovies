package com.santiagolozada.themovies.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.santiagolozada.themovies.R
import com.santiagolozada.themovies.databinding.ActivityMainBinding

class NavHostActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_fragment)
        binding.navView.setupWithNavController(navController)
        
        listeners()
    }

    private fun listeners() {
        binding.navView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.navigation_movies -> {
                    navController.navigate(R.id.listMoviesFragment)
                }
                R.id.navigation_series -> {
                    navController.navigate(R.id.listSeriesMovies)
                }
            }
            true
        }
    }
}