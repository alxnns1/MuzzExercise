package com.alxnns1.muzzexercise.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alxnns1.muzzexercise.ui.model.ChatItem
import com.alxnns1.muzzexercise.ui.model.MessageType

@Composable
fun ChatLogComposable(chatItems: List<ChatItem>) {
    val lazyListState = rememberLazyListState()
    LaunchedEffect(key1 = chatItems.size) { lazyListState.scrollToItem(chatItems.lastIndex) }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        state = lazyListState
    ) {
        items(chatItems) { chatItem ->
            when (chatItem) {
                is ChatItem.SectionHeaderItem -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ChatSectionHeader(sectionHeader = chatItem)
                    }
                }

                is ChatItem.MessageItem -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = chatItem.type.arrangement
                    ) {
                        ChatMessage(message = chatItem)
                    }
                }
            }
        }
    }
}

@Composable
fun ChatSectionHeader(sectionHeader: ChatItem.SectionHeaderItem) {
    Text(modifier = Modifier.padding(vertical = 6.dp), text = sectionHeader.text)
}

@Composable
fun ChatMessage(message: ChatItem.MessageItem) {
    BoxWithConstraints(Modifier) {
        Card(
            modifier = Modifier
                .padding(vertical = 6.dp)
                .widthIn(max = maxWidth * 0.7f),
            shape = message.type.shape,
            backgroundColor = message.type.color,
            elevation = 0.dp
        ) {
            Text(
                modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 12.dp),
                text = message.text
            )
        }
    }
}

@Preview
@Composable
fun ChatLogComposablePreview() {
    Surface { ChatLogComposable(dummyData) }
}

val dummyData = listOf(
    ChatItem.MessageItem(
        "Wowsa Sounds fun",
        MessageType.RECEIVED_WITH_TAIL
    ),
    ChatItem.SectionHeaderItem("Thursday 11:59"),
    ChatItem.MessageItem(
        "Yeh for sure that works. What time do you think?",
        MessageType.RECEIVED_WITH_TAIL
    ),
    ChatItem.MessageItem(
        "Does 7pm work for you? I've got to go pick up my little brother first from a party",
        MessageType.SENT_WITH_TAIL
    ),
    ChatItem.MessageItem(
        "Ok cool!",
        MessageType.RECEIVED_WITH_TAIL
    ),
    ChatItem.MessageItem(
        "What are you up to today?",
        MessageType.SENT_WITH_TAIL
    ),
    ChatItem.MessageItem(
        "Nothing much",
        MessageType.RECEIVED_WITHOUT_TAIL
    ),
    ChatItem.MessageItem(
        "Actually just about to go shopping, got any recommendations for a good shoe shop? I'm a fashion disaster",
        MessageType.RECEIVED_WITH_TAIL
    ),
    ChatItem.MessageItem(
        "The last one went on for hours",
        MessageType.RECEIVED_WITH_TAIL
    )
)