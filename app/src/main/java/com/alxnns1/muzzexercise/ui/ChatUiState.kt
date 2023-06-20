package com.alxnns1.muzzexercise.ui

import com.alxnns1.muzzexercise.ui.model.ChatItem

data class ChatUiState(
    val chatLog: List<ChatItem> = emptyList()
)