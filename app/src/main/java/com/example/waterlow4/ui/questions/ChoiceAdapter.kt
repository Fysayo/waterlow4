package com.example.waterlow4.ui.questions

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.waterlow4.R
import com.example.waterlow4.databinding.ListItemQuestionBinding

class ChoiceAdapter : RecyclerView.Adapter<ChoiceAdapter.QuestionViewHolder>() {

    var choiceList: List<String> = emptyList()
    var selectedPositions = mutableListOf<Int>()

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

    fun reset(list: List<String>) {
        choiceList = list
        selectedPositions.clear()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.binding.apply {
            choiceText.text = choiceList[position]
            if (selectedPositions.contains(position)) {
                choiceText.setTextColor(Color.WHITE)
                choiceText.setBackgroundColor(
                    ContextCompat.getColor(choiceText.context, R.color.light_green)
                )
            } else {
                choiceText.setTextColor(Color.BLACK)
                choiceText.setBackgroundColor(
                    ContextCompat.getColor(choiceText.context, R.color.light_grey)
                )
            }
            choiceText.setOnClickListener {
                val isPreviouslySelected = selectedPositions.contains(position)
                if (isPreviouslySelected) selectedPositions.remove(position)
                else selectedPositions.add(position)
                notifyItemChanged(position)
            }
        }
    }
}