package com.mytakeitapp.feature_user_publication.data.mapper

import com.mytakeitapp.core_database.model.TakeItDbModel
import com.mytakeitapp.feature_user_publication.domain.model.UserPublicationEntity

fun TakeItDbModel.toEntity() = UserPublicationEntity(
    publicationId = publicationId,
    title = title,
    imageUrl = imageUrl,
    description = description,
    address = address,
    number = number,
)