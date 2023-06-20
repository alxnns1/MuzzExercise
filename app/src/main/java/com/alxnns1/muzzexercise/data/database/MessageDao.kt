package com.alxnns1.muzzexercise.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alxnns1.muzzexercise.data.database.model.Message
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM message")
    fun getAll(): Flow<List<Message>>

    @Insert
    fun insertAll(vararg messages: Message)
}