package com.example.achiose.airwatch

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.widget.ImageView

/**
 * Created by achiose on 02/01/18.
 */
fun ImageView.grayScale(applyGrayScale: Boolean) {
    if (applyGrayScale) {
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val cf = ColorMatrixColorFilter(matrix)
        colorFilter = cf
        imageAlpha = 128
    } else {
        colorFilter = null
        imageAlpha = 255
    }
}

fun Int.booleanValue() : Boolean {
    return this > 0
}