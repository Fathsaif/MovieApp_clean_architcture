package com.saif.movieapp.domain.repository

import com.saif.movieapp.domain.model.MoviesInfo
import com.saif.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {
    suspend fun getMovie(id:Int): Flow<Resource<MoviesInfo>>
}