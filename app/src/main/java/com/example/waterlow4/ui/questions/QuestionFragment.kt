package com.example.waterlow4.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waterlow4.databinding.FragmentQuestionBinding
import com.example.waterlow4.models.Question
import com.example.waterlow4.models.questionList

class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel: QuestionVM by activityViewModels()
    private val choiceAdapter = ChoiceAdapter()
    private lateinit var question: Question

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
            val selectedPosition = choiceAdapter.selectedPosition
            if (selectedPosition != null) {
                viewModel.score += question.values[selectedPosition]
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please select an answer to continue",
                    Toast.LENGTH_SHORT
                ).show();
                //TODO display warning to let the user answer the question
                return@setOnClickListener
            }

            if (!viewModel.displayNextQuestion()) {
                //TODO display Result Fragment
            }
        }

        binding?.choicesRecyclerView?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = choiceAdapter
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.questionFragment = this
        viewModel.questionIndex.observe(viewLifecycleOwner) { index ->
            question = questionList[index]
            binding?.title?.text = question.title
            binding?.subtitle?.text = question.subtitle
            binding?.choicesRecyclerView?.scrollToPosition(0)
            choiceAdapter.reset(question.choices)
        }
    }

}