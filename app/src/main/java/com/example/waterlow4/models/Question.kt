package com.example.waterlow4.models

data class Question(
    val title: String = "",
    val subtitle: String? = null,
    val choices: List<String> = emptyList(),
    val values: List<Int> = emptyList(),
    val isMultipleChoices: Boolean = false,
    val selectedOptions: MutableSet<Int> = mutableSetOf(),
)