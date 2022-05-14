package com.saif.movieapp.di

import com.saif.movieapp.data.repository.MoveDetailsRepositoryImpl
import com.saif.movieapp.data.repository.MoviesRepositoryImpl
import com.saif.movieapp.domain.repository.MovieDetailsRepository
import com.saif.movieapp.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {



    @Binds
    @Singleton
    abstract fun bindMoviesRepository(
        moviesRepositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository

    @Binds
    @Singleton
    abstract fun bindMovieDetailsRepository(
        movieDetailsRepository: MoveDetailsRepositoryImpl
    ): MovieDetailsRepository
}