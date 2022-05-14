package com.saif.movieapp.data.repository

import com.saif.movieapp.data.local.MoviesDatabase
import com.saif.movieapp.data.mapper.toMovieInfo
import com.saif.movieapp.data.mapper.toMovieInfoEntity
import com.saif.movieapp.data.remote.MoviesApi
import com.saif.movieapp.domain.model.MoviesInfo
import com.saif.movieapp.domain.repository.MoviesRepository
import com.saif.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    private val api: MoviesApi,
    db: MoviesDatabase,
): MoviesRepository {
    private val dao = db.moviesDao
    private val mSortBy: String = "popularity.desc"


    override suspend fun getMoviesListings(fetchFromRemote: Boolean):Flow< Resource<List<MoviesInfo>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.getMoviesListings()
            emit(Resource.Success(
                data = localListings.map {
                    it.toMovieInfo()
                }
            ))

            val shouldJustLoadFromCache = localListings.isNotEmpty() && !fetchFromRemote
            if(shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                api.getMoviesList(mSortBy)
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.articles?.let { listings ->
                dao.clearNewsListings()
                dao.insertNewsListings(
                    listings?.map { it.toMovieInfoEntity() }
                )
                emit(Resource.Success(
                    data = dao
                        .getMoviesListings()
                        .map { it.toMovieInfo() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }


}