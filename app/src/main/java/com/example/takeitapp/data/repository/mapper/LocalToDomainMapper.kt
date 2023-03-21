package com.example.takeitapp.data.repository.mapper

import com.example.takeitapp.data.local.model.TakeItDbModel
import com.example.takeitapp.domain.model.TakeItEntity

fun TakeItDbModel.toEntity() = TakeItEntity(
    publicationId = publicationId,
    title = title,
    imageUrl = imageUrl,
    description = description,
    address = address,
    number = number,
)