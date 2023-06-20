package com.alxnns1.muzzexercise.domain.model

data class MessageModel(
    val text: String,
    val sentByUser: Boolean,
    val sentTime: Long
)
