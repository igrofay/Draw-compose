package com.example.draw.circles.view

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.draw.circles.model.CirclesEvent
import com.example.draw.circles.model.CirclesState
import com.example.draw.circles.view_model.CirclesVM

@Composable
fun CirclesScreen(
    viewModel: CirclesVM = hiltViewModel(),
) {
    BoxWithConstraints(
        Modifier.fillMaxSize()
    ) {
        val density = LocalDensity.current
        LaunchedEffect(key1 = this){
            val size = with(density){ Size(maxWidth.toPx(), maxHeight.toPx()) }
            viewModel.onEvent(
                CirclesEvent.SizingPlaceEvent(size)
            )
        }
        val state by remember {
            viewModel.state
        }
        when(state){
            CirclesState.AwaitSizingPlaceState -> {}
            is CirclesState.FlowCirclesState -> BoxDrawCirclesWithSettings(
                state as CirclesState.FlowCirclesState,
                DpSize(maxWidth,maxHeight),
                viewModel
            )
        }
    }
}