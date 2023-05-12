package com.takeitapp.network.dataproviders

import com.takeitapp.network.api.TakeItApi
import javax.inject.Inject

class TakeItDataProviders @Inject constructor(private val api: TakeItApi) {

    suspend fun getAllMovies() = api.getAllMovies()

}