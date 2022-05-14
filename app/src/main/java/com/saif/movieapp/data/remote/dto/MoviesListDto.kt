package com.saif.movieapp.data.remote.dto

import com.squareup.moshi.Json

data class MoviesListDto(
    @field:Json(name = "results")
    val articles:List<MoviesInfoDto>
)
