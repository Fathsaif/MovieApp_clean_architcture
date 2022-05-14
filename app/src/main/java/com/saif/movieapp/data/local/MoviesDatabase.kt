package com.saif.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MoviesInfoEntity::class],
    version = 2
)
abstract class MoviesDatabase: RoomDatabase() {
    abstract val moviesDao: MoviesDao
}