package com.saif.movieapp.data.repository

import com.saif.movieapp.data.mapper.toMovieInfo
import com.saif.movieapp.data.remote.MoviesApi
import com.saif.movieapp.domain.model.MoviesInfo
import com.saif.movieapp.domain.repository.MovieDetailsRepository
import com.saif.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoveDetailsRepositoryImpl @Inject constructor(
    private val api: MoviesApi,

    )
    :MovieDetailsRepository {

    override suspend fun getMovie(id: Int): Flow<Resource<MoviesInfo>> {

        return flow {
            emit(Resource.Loading(true))
            val result =  try {
                api.getMovie(id)
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            emit(Resource.Success(
                data = result?.toMovieInfo()
            ))
            emit(Resource.Loading(false))

        }
    }
}