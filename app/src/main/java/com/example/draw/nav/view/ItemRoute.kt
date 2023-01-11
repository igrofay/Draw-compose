package com.example.draw.nav.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.draw.nav.model.MainRouting
import com.example.draw.R

@Composable
fun ItemRoute(
    item: MainRouting,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
    ) {
        Divider(
            color = Color.Gray.copy(.5f)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 14.dp)) {
            Text(text = stringResource(item.name), fontSize = 22.sp, fontWeight = FontWeight.W600)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.ic_baseline_arrow_forward_ios_24),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = Color.Blue
            )
        }
        Divider(
            color = Color.Gray.copy(.5f)
        )
    }
}