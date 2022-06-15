package com.example.waterlow4.models

data class Question(
    val title: String,
    val subtitle: String? = null,
    val choices: List<String>,
    val values: List<Int>,
)
val questionList = listOf(
    Question(
        title = "Gender",
        choices = listOf("Male", "Female"),
        values = listOf(1, 2)
    ),

    Question(
        title = "Age",
        choices = listOf("14 - 49", "50 - 64", "65 - 74", "75 - 80", "81+"),
        values = listOf(1, 2, 3, 4, 5)
    ),

    Question(
        title = "BMI",
        choices = listOf(
            "Average: 20 - 24.9",
            "Above Average: 25 - 29.9",
            "Obese: above 30",
            "Underweight: below 20"
        ),
        values = listOf(0, 1, 2, 3)
    ),

    Question(
        title = "Skin Type",
        choices = listOf(
            "Healthy",
            "Tissue Paper",
            "Dry",
            "Oedamatous",
            "Clammy, Pyrexia",
            "Discoloured (Grade 1)",
            "Broken spots (Grade 2 - 4)"
        ),
        values = listOf(0, 1, 1, 1, 1, 2, 3)
    ),

    Question(
        title = "Mobility",
        choices = listOf(
            "Fully",
            "Restless, Fidgety",
            "Apathetic",
            "Restricted",
            "Bedbound e.g Traction",
            "Chairbound (Wheelchair)"
        ),
        values = listOf(0, 1, 2, 3, 4, 5)
    ),

    Question(
        title = "Continence",
        choices = listOf(
            "Complete, Catheterised",
            "Urine, incontinence",
            "Faecal incontinence",
            "Doubly incontinence"
        ),
        values = listOf(0, 1, 2, 3)
    ),

    Question(
        title = "Recent Weight Loss",
        choices = listOf(
            "No",
            "Unsure",
            "Yes, 0.5 - 5kg",
            "Yes, 5kg - 10kg",
            "Yes, 10kg - 15kg",
            "Yes, >15kg"
        ),
        values = listOf(0, 2, 1, 2, 3, 4)
    ),

    Question(
        title = "Poor Appetite",
        choices = listOf("No", "Yes"),
        values = listOf(0, 1)
    ),

    Question(
        title = "Tissue Malnutrition",
        choices = listOf(
            "None",
            "Restless, Fidgety",
            "Terminal Cachexia",
            "Multiple Organ Failure",
            "Peripheral Vascular Disease",
            "Anemia",
            "Smoking"
        ),
        values = listOf(0, 8, 8, 5, 5, 2, 1)
    ),

    Question(
        title = "Neurological Deficit",
        choices = listOf("None", "Moderate", "Moderate to severe", "Severe"),
        values = listOf(0, 4, 5, 6)
    ),

    Question(
        title = "Major Surgery or Trauma",
        choices = listOf("None", "Orthopaedic/Spinal", "On table > 2 hours", "On table > 6 hours"),
        values = listOf(0, 5, 5, 5)
    ),

    Question(
        title = "Medication",
        subtitle = "High dose steroids, cytotoxicx, anti-inflamatory",
        choices = listOf("None", "1", "2", "3", "4"),
        values = listOf(0, 1, 2, 3, 4)
    ),

    )