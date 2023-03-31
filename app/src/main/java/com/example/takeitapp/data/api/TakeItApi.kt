package com.example.takeitapp.data.api

import com.example.takeitapp.data.remote.TestMovies
import retrofit2.Response
import retrofit2.http.GET

interface TakeItApi {

    @GET("/shows")
    suspend fun getAllMovies() : Response<List<TestMovies>>
}