package com.example.takeitapp.data.repository.mapper

import com.example.takeitapp.data.remote.TestMovies
import com.example.takeitapp.domain.model.TestMoviesEntity

fun TestMovies.toEntity() = TestMoviesEntity(
    id = id,
    name = name,
    summary = summary,
    image = image,
)