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
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentQuestionBinding
import com.example.waterlow4.models.Question
import com.example.waterlow4.ui.main.MainVM
import com.example.waterlow4.utils.hideElevation
import com.example.waterlow4.utils.showElevation
import com.example.waterlow4.utils.showWarning
import java.util.*

class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel: MainVM by activityViewModels()
    private var toast: Toast? = null
    private val choiceAdapter = ChoiceAdapter()
    private var timer: Timer? = null

    private lateinit var question: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater)

        binding?.backButton?.setOnClickListener {
            if (isButtonEnabled().not() && viewModel.getCurrentQuestionIndex() != 0) {
                showWarningToast()
                return@setOnClickListener
            }
            it.hideElevation()
            if (!viewModel.displayPreviousQuestion()) {
                findNavController().popBackStack()
                viewModel.resetSelectedOptions()
            }
        }

        binding?.continueButton?.setOnClickListener {
            if (isButtonEnabled().not()) {
                showWarningToast()
                return@setOnClickListener
            }
            it.hideElevation()
            if (!viewModel.displayNextQuestion()) {
                findNavController().popBackStack()
                findNavController().navigate(R.id.resultFragment)
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
        viewModel.questionIndex.observe(viewLifecycleOwner) { index ->
            question = viewModel.getQuestionOfIndex(index)
            binding?.title?.text = question.title
            binding?.subtitle?.text = question.subtitle
            binding?.subtitle?.visibility =
                if (question.subtitle.isNullOrEmpty()) View.GONE
                else View.VISIBLE
            binding?.choicesRecyclerView?.scrollToPosition(0)
            choiceAdapter.reset(question)
            showButtonElevation()
        }
    }

    private fun showButtonElevation() {
        timer?.cancel()
        timer = Timer().apply {
            schedule(object : TimerTask() {
                override fun run() {
                    requireActivity().runOnUiThread {
                        binding?.backButton?.showElevation()
                        binding?.continueButton?.showElevation()
                    }
                }
            }, 200)
        }
    }

    private fun isButtonEnabled() = viewModel.isCurrentQuestionWithSelectedOptions()

    private fun showWarningToast() {
        toast?.cancel()
        toast = requireContext().showWarning()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
    }
}