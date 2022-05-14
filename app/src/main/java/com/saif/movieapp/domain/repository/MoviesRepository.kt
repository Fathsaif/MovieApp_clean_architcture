package com.saif.movieapp.domain.repository

import com.saif.movieapp.domain.model.MoviesInfo
import com.saif.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {



    suspend fun getMoviesListings(
        fetchFromRemote: Boolean

    ): Flow<Resource<List<MoviesInfo>>>


}