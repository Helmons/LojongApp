package com.provaandroid.lojongapp.data.repository.dataSourceImpl

import com.provaandroid.lojongapp.data.api.APIService
import com.provaandroid.lojongapp.data.model.CheckPointResponse
import com.provaandroid.lojongapp.data.repository.dataSource.LojongRemoteDataSource
import com.provaandroid.lojongapp.data.util.Resource
import retrofit2.Response

class LojongRemoteDataSourceImpl(
    private val apiService: APIService
): LojongRemoteDataSource {
    override suspend fun checkin(id: String): Response<CheckPointResponse> {
        return apiService.getCheckPoint(id)
    }
}