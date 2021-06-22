package com.provaandroid.lojongapp.presentation.di

import com.provaandroid.lojongapp.data.repository.LojongAppRepositoryImpl
import com.provaandroid.lojongapp.data.repository.dataSource.LojongRemoteDataSource
import com.provaandroid.lojongapp.domain.repository.LojongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        lojongRemoteDataSource: LojongRemoteDataSource
    ): LojongRepository {
        return LojongAppRepositoryImpl(
            lojongRemoteDataSource
        )
    }

}