package com.example.waterlow4.ui.questions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionVM : ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    fun setAnswer(optionSelected: Int) {
        _score.value = optionSelected
    }

}
