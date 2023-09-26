package com.example.feature_home.domain.repository

import com.example.feature_home.domain.model.TestMoviesEntity


interface TakeItHomeRepository {

    suspend fun getAllPublication(): List<TestMoviesEntity>
}