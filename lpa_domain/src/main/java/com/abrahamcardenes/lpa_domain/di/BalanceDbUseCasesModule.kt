package com.abrahamcardenes.lpa_domain.di

import com.abrahamcardenes.core_android.date.DateProvider
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.BalanceDbUseCases
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.DeleteBalanceUseCase
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.GetAllCardsUseCase
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.SaveBalanceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BalanceDbUseCasesModule {
    @Singleton
    @Provides
    fun provideBalanceDbUseCases(repository: TravellersRepository, dateProvider: DateProvider): BalanceDbUseCases = BalanceDbUseCases(
        saveCard = SaveBalanceUseCase(repository),
        getAllCards = GetAllCardsUseCase(
            repository = repository,
            dateProvider = dateProvider
        ),
        deleteCard = DeleteBalanceUseCase(repository)
    )
}
