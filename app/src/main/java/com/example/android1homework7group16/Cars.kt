package com.example.android1homework7group16

import androidx.annotation.DrawableRes

data class Cars(
    @DrawableRes val carsImage: Int, // картинка
    val name: String, // имя машины
    val engine: String, // двигател
    val wheels: Int, // калеса
) {
    companion object {
        var count: Int = 0
    }
}
