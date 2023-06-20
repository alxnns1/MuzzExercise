package com.alxnns1.muzzexercise.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomBarComposable(onSend: (String) -> Unit) {
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            value = message,
            onValueChange = { message = it }
        )
        Icon(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                .fillMaxHeight()
                .clickable {
                    if (message.isNotBlank()) {
                        onSend(message)
                        message = ""
                    }
                },
            imageVector = Icons.Default.Send,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun BottomBarComposablePreview() {
    Surface { BottomBarComposable {} }
}