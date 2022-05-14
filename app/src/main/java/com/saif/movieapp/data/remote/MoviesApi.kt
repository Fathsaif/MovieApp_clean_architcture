package com.saif.movieapp.data.remote

import com.saif.movieapp.data.remote.dto.MoviesInfoDto
import com.saif.movieapp.data.remote.dto.MoviesListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/discover/movie")
    suspend fun getMoviesList(@Query("sort_by")  sortBy:String,
                              @Query("api_key") apiKey: String = API_KEY

    ): MoviesListDto

    @GET("3/movie/{id}")
    suspend fun getMovie(
        @Path("id") id:Int,
        @Query("api_key") apiKey: String = API_KEY

    ): MoviesInfoDto


    companion object {
        const val IMAGE_BASE_URL ="http://image.tmdb.org/t/p/w185"
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_KEY = "febf361b8850bffd17e944202d512e89"

    }
}