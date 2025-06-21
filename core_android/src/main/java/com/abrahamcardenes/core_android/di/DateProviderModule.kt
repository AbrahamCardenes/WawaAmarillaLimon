package com.abrahamcardenes.core_android.di

import com.abrahamcardenes.core_android.date.DateProvider
import com.abrahamcardenes.core_android.date.DateProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DateProviderModule {
    @Singleton
    @Provides
    fun provideDateProvider(): DateProvider = DateProviderImpl()
}
