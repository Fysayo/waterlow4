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
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentGenderBinding
import com.example.waterlow4.databinding.FragmentQuestionBinding
import com.example.waterlow4.databinding.FragmentStartBinding

class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel: QuestionVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val binding: FragmentQuestionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false
            )

        binding.backButton.setOnClickListener {view: View -> view.findNavController().navigate(R.id.action_questionFragment_to_startFragment)
        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.questionFragment = this
    }


}