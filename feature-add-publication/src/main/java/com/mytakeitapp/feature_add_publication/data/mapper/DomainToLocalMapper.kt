package com.mytakeitapp.feature_add_publication.data.mapper

import com.mytakeitapp.core_database.model.TakeItDbModel
import com.mytakeitapp.feature_add_publication.domain.model.AddPublicationEntity

fun AddPublicationEntity.toDto() = TakeItDbModel(
    publicationId = publicationId,
    title = title,
    imageUrl = imageUrl,
    description = description,
    address = address,
    number = number
)