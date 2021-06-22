package com.provaandroid.lojongapp.data.repository.dataSource

import com.provaandroid.lojongapp.data.model.CheckPointResponse
import com.provaandroid.lojongapp.data.util.Resource
import retrofit2.Response

interface LojongRemoteDataSource {

    suspend fun checkin(id: String): Response<CheckPointResponse>
}