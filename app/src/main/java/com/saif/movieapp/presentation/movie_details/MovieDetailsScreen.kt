package com.saif.movieapp.presentation.movie_details

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.saif.movieapp.data.remote.MoviesApi.Companion.IMAGE_BASE_URL

@Composable
@Destination
fun MovieDetailsScreen(
    id:Int,
    viewModel:MovieViewModel = hiltViewModel()
){

    val state = viewModel.state
    val movie = state.movieDetail

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollState()
            )
    ) {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(movie?.title?:"Movie Details")
            },
            backgroundColor = MaterialTheme.colors.primarySurface,

            )

            if (state.isLoading){
                Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
            }
            else {
                Column(modifier = Modifier.fillMaxSize()) {

                    AsyncImage(
                        model = IMAGE_BASE_URL+movie?.image,
                        contentDescription = movie?.title,
                        modifier = Modifier
                            .fillMaxWidth().height(200.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = movie?.title ?: "",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth().padding(8.dp),
                        color = MaterialTheme.colors.onBackground
                    )

                    Text(
                        text = movie?.overview ?: "",
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .fillMaxWidth().padding(8.dp),
                        color = MaterialTheme.colors.onBackground
                    )


                }
            }
        }


}