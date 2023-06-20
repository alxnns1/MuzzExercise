package com.alxnns1.muzzexercise.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "sentByUser") val sentByUser: Boolean,
    @ColumnInfo(name = "message") val text: String,
    @ColumnInfo(name = "sent_time") val sentTime: Long
)