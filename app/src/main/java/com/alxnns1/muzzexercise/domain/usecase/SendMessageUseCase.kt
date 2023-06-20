package com.alxnns1.muzzexercise.domain.usecase

import com.alxnns1.muzzexercise.domain.repository.MessageRepository
import com.alxnns1.muzzexercise.domain.model.MessageModel
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val messageRepository: MessageRepository
) {

    operator fun invoke(text: String, sentByUser: Boolean) {
        messageRepository.sendMessage(
            MessageModel(
                text = text,
                sentByUser = sentByUser,
                sentTime = System.currentTimeMillis()
            )
        )
    }
}