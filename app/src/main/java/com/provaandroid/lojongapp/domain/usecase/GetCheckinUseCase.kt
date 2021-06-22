package com.provaandroid.lojongapp.domain.usecase

import com.provaandroid.lojongapp.data.api.APIService
import com.provaandroid.lojongapp.data.model.CheckPointResponse
import com.provaandroid.lojongapp.data.util.Resource
import com.provaandroid.lojongapp.domain.repository.LojongRepository

class GetCheckinUseCase(private val lojongRepository: LojongRepository) {
    suspend fun execute(id: String): Resource<CheckPointResponse>{
        return lojongRepository.checkin(id)
    }


}