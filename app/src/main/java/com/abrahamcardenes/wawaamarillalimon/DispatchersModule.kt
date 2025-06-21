package com.abrahamcardenes.wawaamarillalimon

import com.abrahamcardenes.core.dispatchers.DefaultDispatchersProvider
import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DispatchersModule {

    @Provides
    @Singleton
    fun provideDispatchers(): DispatchersProvider = DefaultDispatchersProvider
}
