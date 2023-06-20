package com.alxnns1.muzzexercise.data.repository

import com.alxnns1.muzzexercise.data.database.MessageDao
import com.alxnns1.muzzexercise.data.database.model.Message
import com.alxnns1.muzzexercise.domain.repository.MessageRepository
import com.alxnns1.muzzexercise.domain.model.MessageModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val messageDao: MessageDao
) : MessageRepository {

    override fun getMessages(): Flow<List<MessageModel>> {
        return messageDao.getAll().map { messages ->
            messages.map {
                with(it) {
                    MessageModel(
                        text = text,
                        sentByUser = sentByUser,
                        sentTime = sentTime
                    )
                }
            }
        }
    }

    override fun sendMessage(message: MessageModel) {
        with(message) {
            messageDao.insertAll(
                Message(
                    text = text,
                    sentByUser = sentByUser,
                    sentTime = sentTime
                )
            )
        }
    }
}