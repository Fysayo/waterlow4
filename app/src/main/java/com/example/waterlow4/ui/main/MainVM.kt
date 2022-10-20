package com.example.waterlow4.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.waterlow4.models.Question
import com.example.waterlow4.utils.buildQuestionList

class MainVM(application: Application) : AndroidViewModel(application) {

    private val questionList: List<Question>
    private val _questionIndex = MutableLiveData(0)
    val questionIndex: LiveData<Int> = _questionIndex

    init {
        questionList = application.buildQuestionList()
    }

    fun displayFirstQuestion() {
        //set the index to zero so that the first tem in the question list is displayed
        _questionIndex.value = 0
    }

    //returns true if there's a next question and
    // returns false if it's already the last question
    fun displayNextQuestion(): Boolean =
        getCurrentQuestionIndex().takeIf { it < questionList.size - 1 }?.let {
            _questionIndex.value = it + 1
            true
        } ?: false

    //returns true if there's a previous question and
    // returns false if it's already the first question
    fun displayPreviousQuestion(): Boolean =
        getCurrentQuestionIndex().takeIf { it > 0 }?.let {
            _questionIndex.value = it - 1
            true
        } ?: false

    fun getCurrentQuestionIndex() = _questionIndex.value ?: 0

    fun isCurrentQuestionWithSelectedOptions() =
        getQuestionOfIndex(getCurrentQuestionIndex()).selectedOptions.isNotEmpty()

    fun getQuestionOfIndex(index: Int) = questionList[index]

    fun resetSelectedOptions() {
        questionList.forEach { it.selectedOptions.clear() }
    }

    fun calculateScore(): Int {
        var score = 0
        questionList.forEach { question ->
            question.selectedOptions.forEach { selectedIndex ->
                score += question.values[selectedIndex]
            }
        }
        return score
    }
}
