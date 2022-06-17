package com.example.waterlow4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.waterlow4.databinding.FragmentStartBinding
import com.example.waterlow4.ui.questions.QuestionVM

class StartFragment : Fragment() {

    private val viewModel: QuestionVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_start, container, false
            )
        binding.button001.setOnClickListener { view: View ->
            viewModel.displayFirstQuestion()
            view.findNavController().navigate(R.id.action_startFragment_to_questionFragment)
        }

        return binding.root
    }

}