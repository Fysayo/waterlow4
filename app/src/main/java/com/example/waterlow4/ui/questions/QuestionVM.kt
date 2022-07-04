package com.example.waterlow4.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waterlow4.models.questionList

class QuestionVM : ViewModel() {
    var score: Int = 0

    private val _questionIndex = MutableLiveData(0)
    val questionIndex: LiveData<Int> = _questionIndex

    fun displayFirstQuestion() {
        //set the index to zero so that the first tem in the question list is displayed
        _questionIndex.value = 0
    }

    //returns true if there's a next question and
    // returns false if it's already the last question
    fun displayNextQuestion(): Boolean{
        return _questionIndex.value?.let {
            return if(it < questionList.size - 1) {
                _questionIndex.value = it + 1
                true
            } else {
                false
            }
        } ?: true
    }

    //returns true if there's a previous question and
    // returns false if it's already the first question
    fun displayPreviousQuestion():Boolean {
        return _questionIndex.value?.takeIf { it > 0 }?.let {
            _questionIndex.value = it - 1
            true
        } ?: false
    }
}
