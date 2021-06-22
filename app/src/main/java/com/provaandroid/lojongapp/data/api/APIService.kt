package com.provaandroid.lojongapp.data.api

import com.provaandroid.lojongapp.data.model.CheckPointResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("{id}")
    suspend fun getCheckPoint(@Path("id") id: String): Response<CheckPointResponse>

}

