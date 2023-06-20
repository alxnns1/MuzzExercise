package com.alxnns1.muzzexercise.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alxnns1.muzzexercise.data.database.model.Message

@Database(entities = [Message::class], version = 1)
abstract class MessageDatabase: RoomDatabase() {
    abstract fun messageDao(): MessageDao
}