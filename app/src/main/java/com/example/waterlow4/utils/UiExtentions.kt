package com.example.waterlow4.utils

import android.content.Context
import android.content.res.Resources.getSystem
import android.view.View
import android.widget.Toast
import com.example.waterlow4.R

val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()
val Int.px: Int get() = (this * getSystem().displayMetrics.density).toInt()

fun View.showElevation() {
    this.elevation = 4.px.toFloat()
}

fun View.hideElevation() {
    this.elevation = 0.px.toFloat()
}

fun Context.showWarning(): Toast =
    Toast.makeText(
        this,
        R.string.warning_message,
        Toast.LENGTH_SHORT
    ).apply { show() }