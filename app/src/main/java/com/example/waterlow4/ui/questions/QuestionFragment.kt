package com.example.waterlow4.ui.questions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private val viewModel: QuestionVM by activityViewModels()
    private lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)

        Log.i("QuestionVM", "called ViewModel!")

        return binding.root
    }

}