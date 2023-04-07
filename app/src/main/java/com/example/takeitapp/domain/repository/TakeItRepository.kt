package com.example.takeitapp.domain.repository

import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.model.TestMoviesEntity
import kotlinx.coroutines.flow.Flow

interface TakeItRepository {

    suspend fun savePublication(publication: TakeItEntity)

    suspend fun getAllPublication(): List<TestMoviesEntity>

    suspend fun getDetailInfoPublication(): TakeItEntity

    fun getUserAllPublication(): Flow<List<TakeItEntity>>

    suspend fun deletePublicationUser(item: TakeItEntity)
}