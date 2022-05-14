package com.saif.movieapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsListings(
        stockListingsEntities: List<MoviesInfoEntity>?
    )

    @Query("DELETE FROM moviesinfoentity")
    suspend fun clearNewsListings()

    @Query(
        """
            SELECT * 
            FROM moviesinfoentity
           
        """
    )
    suspend fun getMoviesListings(): List<MoviesInfoEntity>
}