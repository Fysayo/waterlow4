package com.example.waterlow4.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentResultBinding
import com.example.waterlow4.ui.main.MainVM

class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding? = null
    private val viewModel: MainVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)
        binding?.resetButton?.setOnClickListener {
            viewModel.resetSelectedOptions()
            findNavController().popBackStack()
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score = viewModel.calculateScore()
        binding?.scoreText?.text = score.toString()
        updateRiskText(score)
    }

    private fun updateRiskText(score: Int) {
        @StringRes val riskText: Int
        @ColorRes val riskColor: Int
        when {
            score < 10 -> {
                riskText = R.string.low_risk
                riskColor = R.color.score_green
            }
            score in 10..14 -> {
                riskText = R.string.risk
                riskColor = R.color.score_pink
            }
            score in 15..19 -> {
                riskText = R.string.high_risk
                riskColor = R.color.score_orange
            }
            else -> {
                riskText = R.string.very_high_risk
                riskColor = R.color.score_red
            }
        }
        binding?.riskText?.let {
            it.text = getString(riskText)
            it.setTextColor(ContextCompat.getColor(requireContext(), riskColor))
        }
    }
}