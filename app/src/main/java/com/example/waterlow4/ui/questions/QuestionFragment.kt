package com.example.waterlow4.ui.questions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.waterlow4.R
import com.example.waterlow4.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestionVM
    private lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)

        Log.i("QuestionVM", "called ViewModel!")
        viewModel = ViewModelProviders.of(this).get(QuestionVM::class.java)

        return binding.root
    }

}