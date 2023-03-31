package com.example.takeitapp.domain.model

import com.example.takeitapp.data.remote.Image

data class TestMoviesEntity(
    val id: Int?,
    val name: String?,
    val summary: String?,
    val image: Image?,
)
