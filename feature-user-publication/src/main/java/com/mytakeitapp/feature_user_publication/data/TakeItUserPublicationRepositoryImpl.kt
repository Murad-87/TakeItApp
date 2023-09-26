package com.mytakeitapp.feature_user_publication.data

import com.mytakeitapp.core_database.dao.TakeItDao
import com.mytakeitapp.core_database.model.TakeItDbModel
import com.mytakeitapp.feature_user_publication.data.mapper.toDto
import com.mytakeitapp.feature_user_publication.data.mapper.toEntity
import com.mytakeitapp.feature_user_publication.domain.model.UserPublicationEntity
import com.mytakeitapp.feature_user_publication.domain.repository.TakeItUserPublicationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TakeItUserPublicationRepositoryImpl @Inject constructor(
    private val dao: TakeItDao,
) : TakeItUserPublicationRepository {

    override fun getUserAllPublication(): Flow<List<UserPublicationEntity>> =
        dao.getAllPublication().flatMapConcat { mapPublication(it) }.flowOn(Dispatchers.IO)

    override suspend fun deletePublicationUser(item: UserPublicationEntity) {
        dao.deletePublicationUser(item.toDto())
    }

    override suspend fun getDetailInfoPublication(): UserPublicationEntity {
        TODO("Not yet implemented")
    }

    private fun mapPublication(publication: List<TakeItDbModel>) = flow {
        emit(publication.map { item ->
            item.toEntity()
        })
    }.flowOn(Dispatchers.IO)
}