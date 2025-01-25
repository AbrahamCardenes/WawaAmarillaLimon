package com.abrahamcardenes.wawaamarillalimon.di

import android.app.Application
import androidx.room.Room
import com.abrahamcardenes.wawaamarillalimon.datasource.local.roomDb.WawaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WawaDatabaseProvider {
    @Provides
    @Singleton
    fun provideWawaDatabase(@ApplicationContext application: Application): WawaDatabase = Room.databaseBuilder(
        context = application,
        klass = WawaDatabase::class.java,
        name = "wawa_database"
    )
        .fallbackToDestructiveMigration()
        .build()
}
