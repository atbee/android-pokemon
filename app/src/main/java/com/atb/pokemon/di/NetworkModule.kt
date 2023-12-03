package com.atb.pokemon.di

import com.atb.pokemon.CommonLog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideCommonLog() = CommonLog()
}