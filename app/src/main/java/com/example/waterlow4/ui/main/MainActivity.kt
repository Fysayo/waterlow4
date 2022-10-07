package com.example.waterlow4.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.waterlow4.R
import com.example.waterlow4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.questionFragment) {
            if (!viewModel.displayPreviousQuestion()) {
                navController.popBackStack()
                viewModel.resetSelectedOptions()
            }
            return
        }
        super.onBackPressed()
        viewModel.resetSelectedOptions()
    }
}