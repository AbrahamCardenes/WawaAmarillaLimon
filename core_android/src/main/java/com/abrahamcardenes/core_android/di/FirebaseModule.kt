package com.abrahamcardenes.core_android.di

import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.core_android.firebase.CrashlyticsServiceImpl
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {
    @Singleton
    @Provides
    fun provideFirebaseCrashAnalytics(): CrashlyticsService = CrashlyticsServiceImpl(FirebaseCrashlytics.getInstance())
}
