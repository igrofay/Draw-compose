package com.example.draw.circles.model

import androidx.compose.ui.geometry.Size

sealed class CirclesEvent{
    class SizingPlaceEvent(val size: Size) : CirclesEvent()
    class DrawLineEvent(val isDraw: Boolean): CirclesEvent()
    class ChangeNumberCircle(val number: Int): CirclesEvent()
}
