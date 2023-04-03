package com.example.takeitapp.data.repository

import com.example.takeitapp.data.api.TakeItApi
import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.repository.mapper.toDto
import com.example.takeitapp.data.repository.mapper.toEntity
import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.model.TestMoviesEntity
import com.example.takeitapp.domain.repository.TakeItRepository
import com.example.takeitapp.utils.ApiHelper
import javax.inject.Inject

class TakeItRepositoryImpl @Inject constructor(
    private val dao: TakeItDao,
    private val api: TakeItApi,
    private val apiHelper: ApiHelper
) : TakeItRepository {

    override suspend fun getUserAllPublication(): List<TakeItEntity> {
        val data = dao.getAllPublication()
        return data.map { it.toEntity() }
    }

    override suspend fun savePublication(publication: TakeItEntity) {
        dao.insertPublication(publication.toDto())
    }


    override suspend fun getAllPublication(): List<TestMoviesEntity> {
        val apiResult = apiHelper.apiResponsesHandler { api.getAllMovies() }
        return apiResult.map { movies ->
            movies.toEntity()
        }
    }

    override suspend fun getDetailInfoPublication(): TakeItEntity {
        TODO("Not yet implemented")
    }

}