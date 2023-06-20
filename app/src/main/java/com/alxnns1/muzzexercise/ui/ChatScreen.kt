package com.alxnns1.muzzexercise.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.alxnns1.muzzexercise.ui.composables.BottomBarComposable
import com.alxnns1.muzzexercise.ui.composables.TopBarComposable
import com.alxnns1.muzzexercise.ui.composables.ChatLogComposable
import com.alxnns1.muzzexercise.ui.theme.MuzzExerciseTheme

@Composable
fun ChatScreen() {
    val viewModel: ChatViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    MuzzExerciseTheme {
        Scaffold(
            topBar = { TopBarComposable { viewModel.receiveMessage() } },
            bottomBar = { BottomBarComposable { viewModel.sendMessage(it) } }
        ) { paddingValues ->
            Surface(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    ChatLogComposable(chatItems = uiState.chatLog)
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}