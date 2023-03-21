package com.example.takeitapp.data.repository

import com.example.takeitapp.data.local.dao.TakeItDao
import com.example.takeitapp.data.local.model.TakeItDbModel
import com.example.takeitapp.data.repository.mapper.toEntity
import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.repository.TakeItRepository
import javax.inject.Inject

class TakeItRepositoryImpl @Inject constructor(
    private val dao: TakeItDao,
) : TakeItRepository {

    override suspend fun getUserAllPublication(): TakeItEntity {
        TODO("Not yet implemented")
    }

    override suspend fun savePublication(list: TakeItEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllPublication(): List<TakeItEntity> {
        return dao.getAllPublication().map { it.toEntity() }
    }

    override suspend fun getDetailInfoPublication(): TakeItEntity {
        TODO("Not yet implemented")
    }


}