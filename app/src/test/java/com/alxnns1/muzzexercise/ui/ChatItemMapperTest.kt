package com.alxnns1.muzzexercise.ui

import com.alxnns1.muzzexercise.domain.model.MessageModel
import com.alxnns1.muzzexercise.ui.model.ChatBeginningHeaderItem
import com.alxnns1.muzzexercise.ui.model.ChatItem
import com.alxnns1.muzzexercise.ui.model.MessageType
import org.junit.Assert
import org.junit.Test

class ChatItemMapperTest {

    @Test
    fun `map with message sent by user returns sent message with tail`() {
        val testData = listOf(
            MessageModel(text = "message", sentByUser = true, sentTime = 0L)
        )

        val expected = listOf(
            ChatBeginningHeaderItem,
            ChatItem.SectionHeaderItem("Thursday 01:00"),
            ChatItem.MessageItem(text = "message", MessageType.SENT_WITH_TAIL)
        )

        val actual = ChatItemMapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `map with message sent by other returns received message with tail`() {
        val testData = listOf(
            MessageModel(text = "message", sentByUser = false, sentTime = 0L)
        )

        val expected = listOf(
            ChatBeginningHeaderItem,
            ChatItem.SectionHeaderItem("Thursday 01:00"),
            ChatItem.MessageItem(text = "message", MessageType.RECEIVED_WITH_TAIL)
        )

        val actual = ChatItemMapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `map with messages sent with less than twenty seconds between them returns message without tail`() {
        val testData = listOf(
            MessageModel(text = "message 1", sentByUser = true, sentTime = 0L),
            MessageModel(text = "message 2", sentByUser = true, sentTime = 1L)
        )

        val expected = listOf(
            ChatBeginningHeaderItem,
            ChatItem.SectionHeaderItem("Thursday 01:00"),
            ChatItem.MessageItem(text = "message 1", MessageType.SENT_WITHOUT_TAIL),
            ChatItem.MessageItem(text = "message 2", MessageType.SENT_WITH_TAIL)
        )

        val actual = ChatItemMapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `map with messages sent with more than twenty seconds between them returns message with tail`() {
        val testData = listOf(
            MessageModel(text = "message 1", sentByUser = true, sentTime = 0L),
            MessageModel(text = "message 2", sentByUser = true, sentTime = 30000L)
        )

        val expected = listOf(
            ChatBeginningHeaderItem,
            ChatItem.SectionHeaderItem("Thursday 01:00"),
            ChatItem.MessageItem(text = "message 1", MessageType.SENT_WITH_TAIL),
            ChatItem.MessageItem(text = "message 2", MessageType.SENT_WITH_TAIL)
        )

        val actual = ChatItemMapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `map with messages sent by different users returns messages with tail`() {
        val testData = listOf(
            MessageModel(text = "message 1", sentByUser = true, sentTime = 0L),
            MessageModel(text = "message 2", sentByUser = false, sentTime = 1L),
            MessageModel(text = "message 3", sentByUser = true, sentTime = 2L)
        )

        val expected = listOf(
            ChatBeginningHeaderItem,
            ChatItem.SectionHeaderItem("Thursday 01:00"),
            ChatItem.MessageItem(text = "message 1", MessageType.SENT_WITH_TAIL),
            ChatItem.MessageItem(text = "message 2", MessageType.RECEIVED_WITH_TAIL),
            ChatItem.MessageItem(text = "message 3", MessageType.SENT_WITH_TAIL)
        )

        val actual = ChatItemMapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `map with messages sent with more than one hour between them returns messages separated by section header`() {
        val testData = listOf(
            MessageModel(text = "message 1", sentByUser = true, sentTime = 0L),
            MessageModel(text = "message 2", sentByUser = true, sentTime = 7200000L)
        )

        val expected = listOf(
            ChatBeginningHeaderItem,
            ChatItem.SectionHeaderItem("Thursday 01:00"),
            ChatItem.MessageItem(text = "message 1", MessageType.SENT_WITH_TAIL),
            ChatItem.SectionHeaderItem("Thursday 03:00"),
            ChatItem.MessageItem(text = "message 2", MessageType.SENT_WITH_TAIL)
        )

        val actual = ChatItemMapper.map(testData)

        Assert.assertEquals(expected, actual)
    }
}