package com.alxnns1.muzzexercise.data.database.di

import android.content.Context
import androidx.room.Room
import com.alxnns1.muzzexercise.data.database.MessageDao
import com.alxnns1.muzzexercise.data.database.MessageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideMessageDao(messageDatabase: MessageDatabase): MessageDao {
        return messageDatabase.messageDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MessageDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = MessageDatabase::class.java,
            name = "message"
        ).build()
    }
}