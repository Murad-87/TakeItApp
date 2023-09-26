package com.takeitapp.network.api

import com.takeitapp.network.models.TestMovies
import retrofit2.Response
import retrofit2.http.GET

interface TakeItApi {

    @GET("/shows")
    suspend fun getAllMovies() : Response<List<TestMovies>>
}