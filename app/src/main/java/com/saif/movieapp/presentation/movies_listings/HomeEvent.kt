package com.saif.movieapp.presentation.movies_listings

sealed class HomeEvent {
    object Refresh: HomeEvent()
    data class OnSearchQueryChange(val query: String): HomeEvent()
}
