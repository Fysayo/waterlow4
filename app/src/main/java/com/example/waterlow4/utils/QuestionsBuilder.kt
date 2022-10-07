package com.example.waterlow4.utils

import android.content.Context
import com.example.waterlow4.R
import com.example.waterlow4.models.Question

fun Context.buildQuestionList() = listOf(
    Question(
        getString(R.string.question_1_title),
        getString(R.string.question_1_subtitle),
        resources.getStringArray(R.array.question_1_choices).toList(),
        resources.getIntArray(R.array.question_1_values).toList(),
        resources.getBoolean(R.bool.question_1_is_multiple_choices)
    ),

    Question(
        getString(R.string.question_2_title),
        getString(R.string.question_2_subtitle),
        resources.getStringArray(R.array.question_2_choices).toList(),
        resources.getIntArray(R.array.question_2_values).toList(),
        resources.getBoolean(R.bool.question_2_is_multiple_choices)
    ),

    Question(
        getString(R.string.question_3_title),
        getString(R.string.question_3_subtitle),
        resources.getStringArray(R.array.question_3_choices).toList(),
        resources.getIntArray(R.array.question_3_values).toList(),
        resources.getBoolean(R.bool.question_3_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_4_title),
        getString(R.string.question_4_subtitle),
        resources.getStringArray(R.array.question_4_choices).toList(),
        resources.getIntArray(R.array.question_4_values).toList(),
        resources.getBoolean(R.bool.question_4_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_5_title),
        getString(R.string.question_5_subtitle),
        resources.getStringArray(R.array.question_5_choices).toList(),
        resources.getIntArray(R.array.question_5_values).toList(),
        resources.getBoolean(R.bool.question_5_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_6_title),
        getString(R.string.question_6_subtitle),
        resources.getStringArray(R.array.question_6_choices).toList(),
        resources.getIntArray(R.array.question_6_values).toList(),
        resources.getBoolean(R.bool.question_6_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_7_title),
        getString(R.string.question_7_subtitle),
        resources.getStringArray(R.array.question_7_choices).toList(),
        resources.getIntArray(R.array.question_7_values).toList(),
        resources.getBoolean(R.bool.question_7_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_8_title),
        getString(R.string.question_8_subtitle),
        resources.getStringArray(R.array.question_8_choices).toList(),
        resources.getIntArray(R.array.question_8_values).toList(),
        resources.getBoolean(R.bool.question_8_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_9_title),
        getString(R.string.question_9_subtitle),
        resources.getStringArray(R.array.question_9_choices).toList(),
        resources.getIntArray(R.array.question_9_values).toList(),
        resources.getBoolean(R.bool.question_9_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_10_title),
        getString(R.string.question_10_subtitle),
        resources.getStringArray(R.array.question_10_choices).toList(),
        resources.getIntArray(R.array.question_10_values).toList(),
        resources.getBoolean(R.bool.question_10_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_11_title),
        getString(R.string.question_11_subtitle),
        resources.getStringArray(R.array.question_11_choices).toList(),
        resources.getIntArray(R.array.question_11_values).toList(),
        resources.getBoolean(R.bool.question_11_is_multiple_choices)
    ),
    Question(
        getString(R.string.question_12_title),
        getString(R.string.question_12_subtitle),
        resources.getStringArray(R.array.question_12_choices).toList(),
        resources.getIntArray(R.array.question_12_values).toList(),
        resources.getBoolean(R.bool.question_12_is_multiple_choices)
    ),
)