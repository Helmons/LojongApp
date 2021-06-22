package com.provaandroid.lojongapp.presentation.di

import com.provaandroid.lojongapp.data.api.APIService
import com.provaandroid.lojongapp.data.repository.dataSource.LojongRemoteDataSource
import com.provaandroid.lojongapp.data.repository.dataSourceImpl.LojongRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        apiService: APIService
    ): LojongRemoteDataSource {
        return LojongRemoteDataSourceImpl(apiService)
    }

}