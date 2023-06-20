package com.alxnns1.muzzexercise.domain.usecase

import com.alxnns1.muzzexercise.domain.model.MessageModel
import com.alxnns1.muzzexercise.domain.repository.MessageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    private val messageRepository: MessageRepository
) {

    operator fun invoke(): Flow<List<MessageModel>> {
        return messageRepository.getMessages()
    }
}