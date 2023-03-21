package com.example.takeitapp.domain.repository

import com.example.takeitapp.domain.model.TakeItEntity

interface TakeItRepository {

    suspend fun savePublication(list: TakeItEntity)

    suspend fun getAllPublication(): List<TakeItEntity>

    suspend fun getDetailInfoPublication(): TakeItEntity

    suspend fun getUserAllPublication(): TakeItEntity
}