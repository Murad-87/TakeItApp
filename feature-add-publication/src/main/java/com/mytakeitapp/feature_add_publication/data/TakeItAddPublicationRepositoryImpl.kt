package com.mytakeitapp.feature_add_publication.data

import com.mytakeitapp.core_database.dao.TakeItDao
import com.mytakeitapp.feature_add_publication.data.mapper.toDto
import com.mytakeitapp.feature_add_publication.domain.model.AddPublicationEntity
import com.mytakeitapp.feature_add_publication.domain.repository.TakeItAddPublicationRepository
import javax.inject.Inject

class TakeItAddPublicationRepositoryImpl @Inject constructor(
    private val dao: TakeItDao,
): TakeItAddPublicationRepository {

    override suspend fun savePublication(publication: AddPublicationEntity) {
        dao.insertPublication(publication.toDto())
    }
}