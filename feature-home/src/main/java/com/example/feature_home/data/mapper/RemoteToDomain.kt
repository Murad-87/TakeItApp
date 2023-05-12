package com.example.feature_home.data.mapper

import com.example.feature_home.domain.model.TestMoviesEntity
import com.takeitapp.network.models.TestMovies

fun TestMovies.toEntity() = TestMoviesEntity(
    id = id,
    name = name,
    summary = summary,
    image = image,
)