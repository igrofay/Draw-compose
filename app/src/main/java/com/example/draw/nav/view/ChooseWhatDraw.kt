package com.example.draw.nav.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.draw.nav.model.MainRouting

@Composable
fun ChooseWhatDraw(
    listRoute: List<MainRouting>,
    onSelectRoute: (MainRouting) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.End,
        contentPadding = PaddingValues(vertical = 10.dp)
    ) {
        items(listRoute){
            ItemRoute(item = it) {
                onSelectRoute(it)
            }
        }
    }
}