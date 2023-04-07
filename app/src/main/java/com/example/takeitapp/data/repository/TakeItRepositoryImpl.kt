package com.example.takeitapp.data.repository

import com.example.takeitapp.data.api.TakeItApi
import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.local.model.TakeItDbModel
import com.example.takeitapp.data.repository.mapper.toDto
import com.example.takeitapp.data.repository.mapper.toEntity
import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.model.TestMoviesEntity
import com.example.takeitapp.domain.repository.TakeItRepository
import com.example.takeitapp.utils.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TakeItRepositoryImpl @Inject constructor(
    private val dao: TakeItDao,
    private val api: TakeItApi,
    private val apiHelper: ApiHelper
) : TakeItRepository {

    override fun getUserAllPublication(): Flow<List<TakeItEntity>> =
      dao.getAllPublication().flatMapConcat { mapPublication(it) }.flowOn(Dispatchers.IO)


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

    override suspend fun deletePublicationUser(item: TakeItEntity) {
        dao.deletePublicationUser(item.toDto())
    }

    private fun mapPublication(publication: List<TakeItDbModel>) = flow {
        emit(publication.map {item ->
            item.toEntity()
        })
    }.flowOn(Dispatchers.IO)
}