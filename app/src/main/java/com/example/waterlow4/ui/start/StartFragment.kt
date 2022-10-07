package com.example.waterlow4.ui.start

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentStartBinding
import com.example.waterlow4.ui.main.MainVM

class StartFragment : Fragment() {

    private val viewModel: MainVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate<FragmentStartBinding?>(
                inflater, R.layout.fragment_start, container, false
            ).apply {
                startButton.setOnClickListener {
                    viewModel.displayFirstQuestion()
                    findNavController().navigate(R.id.action_startFragment_to_questionFragment)
                }
                privacyPolicy.movementMethod = LinkMovementMethod.getInstance()
            }
        return binding.root
    }

}