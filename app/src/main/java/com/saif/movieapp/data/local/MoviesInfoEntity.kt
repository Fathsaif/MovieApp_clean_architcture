package com.saif.movieapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class MoviesInfoEntity(
    @PrimaryKey val id: Int? = null,

    val description: String?,
    val title: String?,
    val image: String?,
)
