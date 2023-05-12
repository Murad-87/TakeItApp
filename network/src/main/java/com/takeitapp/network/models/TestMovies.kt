package com.takeitapp.network.models

data class TestMovies(
    val averageRuntime: Int? = null,
    val dvdCountry: Any? = null,
    val ended: String? = null,
    val genres: List<String>,
    val id: Int? = null,
    val image: Image? = null,
    val language: String? = null,
    val name: String? = null,
    val officialSite: String? = null,
    val premiered: String? = null,
    val rating: Rating? = null,
    val runtime: Int? = null,
    val status: String? = null,
    val summary: String? = null,
    val type: String? = null,
    val updated: Int? = null,
    val url: String? = null,
    val webChannel: Any? = null,
    val weight: Int? = null
)