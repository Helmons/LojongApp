package com.provaandroid.lojongapp.presentation.di

import com.provaandroid.lojongapp.domain.repository.LojongRepository
import com.provaandroid.lojongapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideCheckinUseCase(
        lojongRepository: LojongRepository
    ):GetCheckinUseCase{
        return GetCheckinUseCase(lojongRepository)
    }
}