package com.provaandroid.lojongapp.domain.repository

import com.provaandroid.lojongapp.data.model.CheckPointResponse
import com.provaandroid.lojongapp.data.util.Resource

interface LojongRepository{

    suspend fun checkin(id: String): Resource<CheckPointResponse>

}