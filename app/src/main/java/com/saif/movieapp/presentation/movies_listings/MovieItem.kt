package com.saif.movieapp.presentation.movies_listings

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saif.movieapp.data.remote.MoviesApi
import com.saif.movieapp.domain.model.MoviesInfo

@Composable
fun MovieItem(
    movies: MoviesInfo,
    modifier: Modifier = Modifier

) {
    var image = MoviesApi.IMAGE_BASE_URL+movies.image.toString()

    Row(
        modifier = modifier

    ) {
        AsyncImage(
            model = image,
            contentDescription = movies.title,
            modifier = Modifier
                .fillMaxHeight().align(Alignment.CenterVertically).padding(4.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()

        ) {
            Text(
                text = movies.title ?: "",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth().padding(4.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colors.onBackground
            )

            Text(
                text = movies.overview ?: "",
                fontWeight = FontWeight.Light,
                maxLines = 3,
                modifier = Modifier
                    .fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onBackground
            )

            Spacer(modifier = Modifier.width(8.dp))

        }


    }


}