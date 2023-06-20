package com.alxnns1.muzzexercise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alxnns1.muzzexercise.domain.usecase.GetMessagesUseCase
import com.alxnns1.muzzexercise.domain.usecase.SendMessageUseCase
import com.alxnns1.muzzexercise.ui.model.ChatBeginningHeaderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    getMessagesUseCase: GetMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

    val uiState: StateFlow<ChatUiState> = getMessagesUseCase().map {
        ChatUiState(ChatItemMapper.map(it))
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        ChatUiState(listOf(ChatBeginningHeaderItem))
    )

    fun sendMessage(message: String) {
        viewModelScope.launch(Dispatchers.IO) {
            sendMessageUseCase(text = message, sentByUser = true)
        }
    }

    fun receiveMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            sendMessageUseCase(text = "Lorem ipsum", sentByUser = false)
        }
    }
}