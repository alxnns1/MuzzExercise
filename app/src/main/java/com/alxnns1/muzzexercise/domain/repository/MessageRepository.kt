package com.alxnns1.muzzexercise.domain.repository

import com.alxnns1.muzzexercise.domain.model.MessageModel
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    fun getMessages(): Flow<List<MessageModel>>
    fun sendMessage(message: MessageModel)
}