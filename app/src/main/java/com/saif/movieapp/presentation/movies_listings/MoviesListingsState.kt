package com.saif.movieapp.presentation.movies_listings

import com.saif.movieapp.domain.model.MoviesInfo

data class MoviesListingsState(
    val moviesList: List<MoviesInfo> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
)
