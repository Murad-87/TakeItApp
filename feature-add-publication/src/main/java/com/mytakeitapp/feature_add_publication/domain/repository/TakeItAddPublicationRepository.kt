package com.mytakeitapp.feature_add_publication.domain.repository

import com.mytakeitapp.feature_add_publication.domain.model.AddPublicationEntity


interface TakeItAddPublicationRepository {

    suspend fun savePublication(publication: AddPublicationEntity)
}