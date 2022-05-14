package com.saif.movieapp.presentation.movie_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saif.movieapp.domain.repository.MovieDetailsRepository
import com.saif.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository,
    private val savedStateHandle: SavedStateHandle,

    ):ViewModel(){

    var state by mutableStateOf(MovieDetailsState())

    init {
        val id = savedStateHandle.get<Int>("id") ?: 0
        getMovie(id)
    }
     fun getMovie(
        id: Int
    ) {
        viewModelScope.launch {
            movieDetailsRepository
                .getMovie(id)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { movie ->
                                state = state.copy(movieDetail = movie)
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }


}