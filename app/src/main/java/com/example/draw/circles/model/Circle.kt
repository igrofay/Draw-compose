package com.example.draw.circles.model

import androidx.compose.ui.graphics.Color

data class Circle(
    val radius: Float,
    var x: Float,
    var y: Float,
    var speedX: Float,
    var speedY: Float,
    val color: Color,
)
