package com.alxnns1.muzzexercise.ui.model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.alxnns1.muzzexercise.ui.theme.LightGray
import com.alxnns1.muzzexercise.ui.theme.Pink

val ChatBeginningHeaderItem = ChatItem.SectionHeaderItem("Beginning of chat")

sealed class ChatItem {
    data class SectionHeaderItem(val text: String) : ChatItem()
    data class MessageItem(val text: String, val type: MessageType) : ChatItem()
}

enum class MessageType(val shape: Shape, val color: Color, val arrangement: Arrangement.Horizontal) {
    SENT_WITH_TAIL(
        RoundedCornerShape(16.dp, 16.dp, 0.dp, 16.dp),
        Pink,
        Arrangement.End
    ),
    SENT_WITHOUT_TAIL(
        RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp),
        Pink,
        Arrangement.End
    ),
    RECEIVED_WITH_TAIL(
        RoundedCornerShape(16.dp, 16.dp, 16.dp, 0.dp),
        LightGray,
        Arrangement.Start
    ),
    RECEIVED_WITHOUT_TAIL(
        RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp),
        LightGray,
        Arrangement.Start
    )
}