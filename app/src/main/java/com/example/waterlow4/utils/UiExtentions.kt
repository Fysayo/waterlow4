package com.example.waterlow4.utils

import android.content.res.Resources.getSystem
import android.view.View

val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()
val Int.px: Int get() = (this * getSystem().displayMetrics.density).toInt()

fun View.showElevation() {
    this.elevation = 4.px.toFloat()
}

fun View.hideElevation() {
    this.elevation = 0.px.toFloat()
}