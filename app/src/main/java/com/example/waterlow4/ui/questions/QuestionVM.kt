package com.example.waterlow4.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionVM : ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _questionIndex = MutableLiveData(-1)
    val questionIndex: LiveData<Int> = _questionIndex

    fun displayFirstQuestion() {
        _questionIndex.value = 0
    }

    fun displayNextQuestion() {
        _questionIndex.value?.let {
            _questionIndex.value = it + 1
        }
    }

    fun displayPreviousQuestion() {
        _questionIndex.value?.takeIf { it > 0 }?.let {
            _questionIndex.value = it - 1
        }
    }

    fun setAnswer(optionSelected: Int) {
        _score.value =+ optionSelected
    }

}
