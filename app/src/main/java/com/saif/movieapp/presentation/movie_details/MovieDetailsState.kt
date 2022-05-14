package com.saif.movieapp.presentation.movie_details

import com.saif.movieapp.domain.model.MoviesInfo

data class MovieDetailsState (
    val movieDetail:MoviesInfo?=null,
    val isLoading: Boolean = false,

    )
