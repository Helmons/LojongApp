package com.provaandroid.lojongapp.presentation.di

import android.app.Application
import com.provaandroid.lojongapp.domain.usecase.*
import com.provaandroid.lojongapp.presentation.viewmodel.LojongViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getCheckinUseCase: GetCheckinUseCase

    ):LojongViewModelFactory{
        return LojongViewModelFactory(
            application,
            getCheckinUseCase
        )
    }

}