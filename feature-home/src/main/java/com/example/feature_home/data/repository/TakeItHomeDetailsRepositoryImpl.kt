package com.example.feature_home.data.repository

import com.example.feature_home.domain.model.TestDetailsPublicationEntity
import com.example.feature_home.domain.repository.TakeItHomeDetailsRepository
import com.takeitapp.network.api.TakeItApi
import com.takeitapp.network.utils.ApiHelper
import javax.inject.Inject

class TakeItHomeDetailsRepositoryImpl @Inject constructor(
    private val api: TakeItApi,
    private val apiHelper: ApiHelper
) : TakeItHomeDetailsRepository {

    override suspend fun getDetailsPublication(id: Int): TestDetailsPublicationEntity {
        TODO("Not yet implemented")
    }
}