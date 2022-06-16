package com.example.waterlow4.ui.questions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waterlow4.R
import com.example.waterlow4.models.Question
import com.example.waterlow4.models.questionList

class QuestionAdapter (
    var question: List<Question>
    ): RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return question.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.itemView.apply {

        }
        }

    }
}