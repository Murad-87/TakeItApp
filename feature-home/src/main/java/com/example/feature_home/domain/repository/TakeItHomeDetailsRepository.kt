package com.example.feature_home.domain.repository

import com.example.feature_home.domain.model.TestDetailsPublicationEntity

interface TakeItHomeDetailsRepository {

    suspend fun getDetailsPublication(id: Int) : TestDetailsPublicationEntity
}