package com.abrahamcardenes.core_db.di

import android.content.Context
import androidx.room.Room
import com.abrahamcardenes.core_db.roomDb.WawaDatabase
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
    fun provideWawaDatabase(@ApplicationContext context: Context): WawaDatabase = Room.databaseBuilder(
        context = context,
        klass = WawaDatabase::class.java,
        name = "wawa_database"
    )
        .build()

    @Provides
    @Singleton
    fun provideBusStopDao(db: WawaDatabase) = db.busStopDao()

    @Provides
    @Singleton
    fun provideWawaBalanceDao(db: WawaDatabase) = db.wawaBalanceDao()
}
