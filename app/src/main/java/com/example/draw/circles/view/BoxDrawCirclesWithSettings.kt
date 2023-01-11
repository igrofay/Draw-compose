package com.example.draw.circles.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import com.example.draw.circles.model.CirclesEvent
import com.example.draw.circles.model.CirclesState
import com.example.draw.common.view_model.EventBase

@Composable
fun BoxDrawCirclesWithSettings(
    flowCirclesState: CirclesState.FlowCirclesState,
    size: DpSize,
    eventBase: EventBase<CirclesEvent>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DrawingSettings(flowCirclesState = flowCirclesState, eventBase = eventBase)
        DrawCircles(flowCirclesState, size)
    }
}