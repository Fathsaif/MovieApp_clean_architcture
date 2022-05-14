package com.saif.movieapp.data.remote.dto

import com.squareup.moshi.Json

data class MoviesInfoDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "overview") val description: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "poster_path") val image: String?,
    @field:Json(name = "results") val date: String?,
)
