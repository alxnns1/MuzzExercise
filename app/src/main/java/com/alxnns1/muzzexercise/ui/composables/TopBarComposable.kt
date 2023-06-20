package com.alxnns1.muzzexercise.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBarComposable(onClick: () -> Unit) {
    TopAppBar(
        modifier = Modifier.clickable { onClick() },
        title = {
            Row {
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp),
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Sarah"
                )
            }
        },
        navigationIcon = {
            Icon(
                modifier = Modifier.fillMaxWidth(),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
        },
        actions = {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Preview
@Composable
fun TopBarComposablePreview() {
    Surface { TopBarComposable {} }
}