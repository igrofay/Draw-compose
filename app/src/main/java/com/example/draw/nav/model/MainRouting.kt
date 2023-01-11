package com.example.draw.nav.model

import androidx.annotation.StringRes
import com.example.draw.R

sealed class MainRouting(val route: String, @StringRes val name: Int){
    object CirclesDraw : MainRouting(
        "circles_draw",
        R.string.drawing_circles
    )
    companion object{
        val listRoute by lazy {
            listOf<MainRouting>(
                CirclesDraw,
            )
        }
        const val route = "choose_what_draw"
    }
}
