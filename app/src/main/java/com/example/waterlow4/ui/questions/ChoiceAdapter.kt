package com.example.waterlow4.ui.questions

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.waterlow4.R
import com.example.waterlow4.databinding.ListItemQuestionBinding
import com.example.waterlow4.models.Question
import com.example.waterlow4.utils.px

class ChoiceAdapter : RecyclerView.Adapter<ChoiceAdapter.QuestionViewHolder>() {

    private var question: Question = Question()

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
        return question.choices.size
    }

    fun reset(question: Question) {
        this.question = question
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.binding.apply {
            cardView.setOnClickListener { setItemClickListener(position) }
            choiceText.text = question.choices[position]

            @ColorRes val textColor: Int
            @ColorRes val backgroundColor: Int
            @ColorRes val strokeColor: Int
            val elevation: Int

            if (question.selectedOptions.contains(position)) {
                textColor = R.color.white
                backgroundColor = R.color.light_green
                strokeColor = R.color.choice_stroke_color_selected
                elevation = 0
            } else {
                textColor = R.color.black
                backgroundColor = R.color.white
                strokeColor = R.color.choice_stroke_color_unselected
                elevation = 4
            }
            val context = choiceText.context
            choiceText.setTextColor(ContextCompat.getColor(context, textColor))
            cardView.setCardBackgroundColor(
                ColorStateList.valueOf(
                    ContextCompat.getColor(context, backgroundColor)
                )
            )
            cardView.setStrokeColor(
                ColorStateList.valueOf(
                    ContextCompat.getColor(context, strokeColor)
                )
            )
            cardView.cardElevation = elevation.px.toFloat()
        }
    }

    private fun setItemClickListener(position: Int) {
        with(question.selectedOptions) {
            when {
                contains(position) -> remove(position)
                question.isMultipleChoices -> add(position)
                else -> {
                    clear()
                    add(position)
                }
            }
        }
        notifyDataSetChanged()
    }
}