package com.example.feature_home.data

import com.example.feature_home.data.mapper.toEntity
import com.example.feature_home.domain.model.TestMoviesEntity
import com.example.feature_home.domain.repository.TakeItHomeRepository
import com.takeitapp.network.api.TakeItApi
import com.takeitapp.network.utils.ApiHelper
import javax.inject.Inject

class TakeItHomeRepositoryImpl @Inject constructor(
    private val api: TakeItApi,
    private val apiHelper: ApiHelper
): TakeItHomeRepository {


    override suspend fun getAllPublication(): List<TestMoviesEntity> {
        val apiResult = apiHelper.apiResponsesHandler { api.getAllMovies() }
        return apiResult.map { movies ->
            movies.toEntity()
        }
    }
}