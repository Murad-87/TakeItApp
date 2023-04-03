package com.example.takeitapp.domain.repository

import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.model.TestMoviesEntity

interface TakeItRepository {

    suspend fun savePublication(publication: TakeItEntity)

    suspend fun getAllPublication(): List<TestMoviesEntity>

    suspend fun getDetailInfoPublication(): TakeItEntity

    suspend fun getUserAllPublication(): List<TakeItEntity>
}