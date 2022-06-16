package com.example.waterlow4.ui.questions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentGenderBinding
import com.example.waterlow4.databinding.FragmentQuestionBinding
import com.example.waterlow4.databinding.FragmentStartBinding
import com.example.waterlow4.models.questionList

class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel: QuestionVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater)

        binding?.backButton?.setOnClickListener {
            if (!viewModel.displayPreviousQuestion())
                findNavController().popBackStack()
        }

        binding?.continueButton?.setOnClickListener {
            if (!viewModel.displayNextQuestion()) {
                // TODO display Result Fragment
            }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.questionFragment = this

        viewModel.questionIndex.observe(viewLifecycleOwner) { index ->
            val question = questionList[index]
            binding?.title?.text = question.title
            binding?.subtitle?.text = question.subtitle
        }
    }

}
