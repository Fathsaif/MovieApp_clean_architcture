package com.saif.movieapp.data.mapper

import com.saif.movieapp.data.local.MoviesInfoEntity
import com.saif.movieapp.data.remote.dto.MoviesInfoDto
import com.saif.movieapp.domain.model.MoviesInfo

fun MoviesInfoEntity.toMovieInfo(): MoviesInfo {

    return MoviesInfo(
        id= id,
        title = title ?: "",
        overview = description ?: "",
        image = image ?: "",
    )
}
fun MoviesInfoDto.toMovieInfoEntity(): MoviesInfoEntity {

    return MoviesInfoEntity(
        id= id,
        title = title ?: "",
        description = description ?: "",
        image = image ?: "",
    )
}
fun MoviesInfoDto.toMovieInfo(): MoviesInfo {

    return MoviesInfo(
        id= id,
        title = title ?: "",
        overview = description ?: "",
        image = image ?: "",
    )
}