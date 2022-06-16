package com.example.waterlow4.ui.questions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waterlow4.models.questionList

class QuestionVM : ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _questionIndex = MutableLiveData(-1)
    val questionIndex: LiveData<Int> = _questionIndex

    fun displayFirstQuestion() {
        _questionIndex.value = 0
    }

    fun displayPreviousQuestion(): Boolean {
        return _questionIndex.value?.takeIf { it > 0 }?.let {
            _questionIndex.value = it - 1
            true
        } ?: false
    }


    fun displayNextQuestion(): Boolean {
        return _questionIndex.value?.let {
            return if (it < questionList.size - 1) {
                _questionIndex.value = it + 1
                true
            } else {
                false
            }
        } ?: true
    }

    fun setAnswer(optionSelected: Int) {
        _score.value = +optionSelected
    }

}



