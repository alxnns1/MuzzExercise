package com.alxnns1.muzzexercise.data.repository.di

import com.alxnns1.muzzexercise.data.repository.MessageRepositoryImpl
import com.alxnns1.muzzexercise.domain.repository.MessageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideMessageRepository(repository: MessageRepositoryImpl): MessageRepository
}