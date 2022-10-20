package com.example.waterlow4.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.waterlow4.R
import com.example.waterlow4.databinding.ActivityMainBinding
import com.example.waterlow4.utils.showWarning

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel: MainVM by viewModels()
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.questionFragment) {
            when {
                viewModel.getCurrentQuestionIndex() == 0 -> {
                    navController.popBackStack()
                    viewModel.resetSelectedOptions()
                }
                viewModel.isCurrentQuestionWithSelectedOptions() -> {
                    viewModel.displayPreviousQuestion()
                }
                else -> {
                    toast?.cancel()
                    showWarning()
                }
            }
            return
        }
        super.onBackPressed()
        viewModel.resetSelectedOptions()
    }
}