package com.example.waterlow4.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.waterlow4.databinding.FragmentQuestionBinding
import com.example.waterlow4.models.questionList

class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel: QuestionVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //observe the index of the question and display its data
        viewModel.questionIndex.observe(viewLifecycleOwner) {
            val question = questionList[it]
            binding?.title?.text = question.title
            binding?.subtitle?.text = question.subtitle

            //Display choices here....


        }

        //when the user click on continue button, the next question will be displayed
        binding?.continueButton?.setOnClickListener {
            viewModel.displayNextQuestion()
        }
    }


}