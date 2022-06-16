package com.example.waterlow4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.waterlow4.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_start, container, false
            )
        binding.button001.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_startFragment_to_questionFragment)
        }

        return binding.root
    }

}