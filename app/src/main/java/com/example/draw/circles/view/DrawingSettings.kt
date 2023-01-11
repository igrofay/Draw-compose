package com.example.draw.circles.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Slider
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw.circles.model.CirclesEvent
import com.example.draw.circles.model.CirclesState
import com.example.draw.common.view_model.EventBase

@Composable
fun DrawingSettings(
    flowCirclesState: CirclesState.FlowCirclesState,
    eventBase: EventBase<CirclesEvent>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Рисовать линии",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400
            )
            Switch(
                checked = flowCirclesState.isDrawLine,
                onCheckedChange = { eventBase.onEvent(CirclesEvent.DrawLineEvent(it)) })
        }
        Divider(color = Color.Gray)
        Text(
            text = "Количество кругов: ${flowCirclesState.number}",
            fontSize = 18.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(top = 10.dp)
        )
        Slider(
            value = flowCirclesState.number.toFloat(),
            onValueChange = {
                eventBase.onEvent(CirclesEvent.ChangeNumberCircle(it.toInt()))
            },
            valueRange = 1f..10f,
            steps =8,
            modifier = Modifier.fillMaxWidth(.8f)
        )
        Divider(color = Color.Gray)
    }
}