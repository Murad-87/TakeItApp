package com.mytakeitapp.feature_user_publication.domain.repository


import com.mytakeitapp.feature_user_publication.domain.model.UserPublicationEntity
import kotlinx.coroutines.flow.Flow

interface TakeItUserPublicationRepository {

    fun getUserAllPublication(): Flow<List<UserPublicationEntity>>

    suspend fun deletePublicationUser(item: UserPublicationEntity)

    suspend fun getDetailInfoPublication(): UserPublicationEntity
}