package com.abrahamcardenes.core_android.di

import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.core_android.firebase.CrashlyticsServiceImpl
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsService
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsServiceImpl
import com.google.firebase.Firebase
import com.google.firebase.analytics.analytics
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

    @Singleton
    @Provides
    fun provideFirebaseAnalytics(): AnalyticsService = AnalyticsServiceImpl(firebaseAnalytics = Firebase.analytics)
}
