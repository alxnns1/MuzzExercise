package com.alxnns1.muzzexercise.ui

import com.alxnns1.muzzexercise.domain.model.MessageModel
import com.alxnns1.muzzexercise.ui.model.ChatBeginningHeaderItem
import com.alxnns1.muzzexercise.ui.model.ChatItem
import com.alxnns1.muzzexercise.ui.model.MessageType
import com.alxnns1.muzzexercise.util.DateUtil
import java.util.concurrent.TimeUnit

object ChatItemMapper {

    fun map(messages: List<MessageModel>): List<ChatItem> {
        val chatItems = mutableListOf<ChatItem>(ChatBeginningHeaderItem)

        messages.forEachIndexed { index, message ->
            val previousMessage = messages.getOrNull(index - 1)
            val nextMessage = messages.getOrNull(index + 1)

            val timeSinceLastMessage = message.sentTime - (previousMessage?.sentTime ?: Long.MIN_VALUE)
            val timeTillNextMessage = (nextMessage?.sentTime ?: Long.MAX_VALUE) - message.sentTime
            val sameUserAsNextMessage = nextMessage?.sentByUser == message.sentByUser
            val moreThanOneHourSinceLastMessage = timeSinceLastMessage > TimeUnit.HOURS.toMillis(1)
            val lessThanTwentySecondsTillNextMessage = timeTillNextMessage <= TimeUnit.SECONDS.toMillis(20)

            if (moreThanOneHourSinceLastMessage || index == 0) {
                chatItems.add(ChatItem.SectionHeaderItem(DateUtil.timestampToDateTimeString(message.sentTime)))
            }
            if (lessThanTwentySecondsTillNextMessage && sameUserAsNextMessage) {
                if (message.sentByUser) {
                    chatItems.add(ChatItem.MessageItem(message.text, MessageType.SENT_WITHOUT_TAIL))
                } else {
                    chatItems.add(ChatItem.MessageItem(message.text, MessageType.RECEIVED_WITHOUT_TAIL))
                }
            } else {
                if (message.sentByUser) {
                    chatItems.add(ChatItem.MessageItem(message.text, MessageType.SENT_WITH_TAIL))
                } else {
                    chatItems.add(ChatItem.MessageItem(message.text, MessageType.RECEIVED_WITH_TAIL))
                }
            }
        }

        return chatItems
    }
}