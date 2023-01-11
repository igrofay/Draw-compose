package com.example.draw.circles.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import com.example.draw.circles.model.CirclesState

@Composable
fun DrawCircles(
    flowCirclesState: CirclesState.FlowCirclesState,
    size: DpSize,
) {
    val flowCircles by flowCirclesState
        .flowData
        .collectAsState(initial = emptyList())
    Canvas(Modifier.size(size)) {
        if(flowCirclesState.isDrawLine){
            for (i in flowCircles.indices){
                for (y in i.inc() until flowCircles.size){
                    val item1 = flowCircles[i]
                    val item2 = flowCircles[y]
                    drawLine(
                        Color.Black,
                        start = Offset(item1.x, item1.y),
                        end = Offset(item2.x, item2.y)
                    )
                }
            }
        }
        for (item in flowCircles) {
            drawCircle(
                item.color,
                item.radius,
                center = Offset(item.x, item.y)
            )
        }
    }
}