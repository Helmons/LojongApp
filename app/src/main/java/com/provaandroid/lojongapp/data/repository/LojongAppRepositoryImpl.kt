package com.provaandroid.lojongapp.data.repository

import com.provaandroid.lojongapp.data.model.CheckPointResponse
import com.provaandroid.lojongapp.data.repository.dataSource.LojongRemoteDataSource
import com.provaandroid.lojongapp.data.util.Resource
import com.provaandroid.lojongapp.domain.repository.LojongRepository
import retrofit2.Response

class LojongAppRepositoryImpl(
    private val lojongRemoteDataSource: LojongRemoteDataSource
):LojongRepository {

    private fun responseToResource(response: Response<CheckPointResponse>):Resource<CheckPointResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun checkin(id: String): Resource<CheckPointResponse> {
        return responseToResource(lojongRemoteDataSource.checkin(id))
    }


}