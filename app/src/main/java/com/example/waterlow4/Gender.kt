package com.example.waterlow4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.waterlow4.databinding.FragmentGenderBinding

class Gender : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGenderBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_gender, container, false
            )
        return binding.root
    }

}