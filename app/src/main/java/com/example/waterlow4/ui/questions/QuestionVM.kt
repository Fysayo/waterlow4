package com.example.waterlow4.ui.questions

import android.util.Log
import androidx.lifecycle.ViewModel

class QuestionVM : ViewModel() {
    init {
        Log.i("QuestionVM", "QuestionVM created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("QuestionVM", "QuestionVM destroyed")
    }

}
