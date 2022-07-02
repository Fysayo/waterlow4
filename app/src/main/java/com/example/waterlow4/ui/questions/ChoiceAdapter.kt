package com.example.waterlow4.ui.questions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waterlow4.databinding.ListItemQuestionBinding

class ChoiceAdapter : RecyclerView.Adapter<ChoiceAdapter.QuestionViewHolder>() {

    var choiceList: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = ListItemQuestionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return QuestionViewHolder(binding)
    }

    inner class QuestionViewHolder(val binding: ListItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return choiceList.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.binding.apply {
            choiceText.text = choiceList[position]
        }
    }
}