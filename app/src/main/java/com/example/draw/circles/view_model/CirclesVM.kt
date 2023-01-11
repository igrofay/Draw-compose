package com.example.draw.circles.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.draw.circles.model.CirclesEvent
import com.example.draw.circles.model.CirclesState
import com.example.draw.common.view_model.EventBase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CirclesVM @Inject constructor() : ViewModel(), EventBase<CirclesEvent> {
    private val _state = mutableStateOf<CirclesState>(CirclesState.AwaitSizingPlaceState)
    val state : State<CirclesState> by ::_state
    override fun onEvent(event: CirclesEvent) {
        when (event) {
            is CirclesEvent.SizingPlaceEvent -> {
                _state.value = CirclesState.FlowCirclesState(event.size)
            }
            is CirclesEvent.DrawLineEvent -> {
                (_state.value as? CirclesState.FlowCirclesState)
                    ?.copy(isDrawLine = event.isDraw)?.let {
                        _state.value = it
                    }
            }
            is CirclesEvent.ChangeNumberCircle ->{
                val stateValue = _state.value as? CirclesState.FlowCirclesState
                if (event.number == stateValue?.number){ return }
                stateValue?.copy(number = event.number)?.let {
                    _state.value = it
                }
            }
        }
    }

}