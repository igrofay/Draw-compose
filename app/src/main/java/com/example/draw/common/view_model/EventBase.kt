package com.example.draw.common.view_model

interface EventBase<T> {
    fun onEvent(event: T)
}