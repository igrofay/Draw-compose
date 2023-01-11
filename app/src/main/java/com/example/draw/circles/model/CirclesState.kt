package com.example.draw.circles.model

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import java.util.Calendar;
import java.util.Date;

sealed class CirclesState{
    object AwaitSizingPlaceState : CirclesState()
    data class FlowCirclesState(
        val size: Size,
        val number: Int = 5,
        val isDrawLine: Boolean = false,
        var circleList : List<Circle> = emptyList()
    ): CirclesState(){
        private val random = Random(Calendar.getInstance().time.time)
        val flowData = flow {
            if (circleList.size < number){
                generateList()
            }else if(circleList.size > number){
                removeExtraCircles()
            }
            while (true){
                emit(circleList)
                delay(16)
                move()
            }
        }

        private fun move() {
            val replacementValue = mutableListOf<Circle>()
            for (item in circleList){
                if (
                    item.x + item.speedX < item.radius ||
                    item.x + item.speedX > size.width - item.radius
                ){
                    item.speedX *= -1
                }
                if (
                    item.y + item.speedY < item.radius ||
                    item.y + item.speedY > size.height - item.radius
                ){
                    item.speedY *= -1
                }
                replacementValue.add(item.copy(
                    x = item.x + item.speedX,
                    y = item.y + item.speedY,
                ))
            }
            circleList = replacementValue
        }
        private fun removeExtraCircles(){
            val replacementValue = circleList.toMutableList()
            for (i in number until circleList.size){
                replacementValue.removeLast()
            }
            circleList = replacementValue
        }

        private fun generateList(){
            val replacementValue = circleList.toMutableList()
            for (i in circleList.size until number){
                replacementValue.add(generateCircle())
            }
            circleList = replacementValue
        }

        private fun generateCircle(): Circle{
            val radius = random.nextInt(20,80)
            val x = random.nextInt(radius, size.width.toInt() - radius)
            val y = random.nextInt(radius, size.height.toInt() - radius)
            val color = Color(
                red = random.nextFloat(),
                green = random.nextFloat(),
                blue = random.nextFloat(),
            )
            return  Circle(
                radius = radius.toFloat(),
                x = x.toFloat(), y = y.toFloat(),
                speedX = random.nextInt(5,30).toFloat(),
                speedY = random.nextInt(5,30).toFloat(),
                color = color
            )
        }

    }

}
