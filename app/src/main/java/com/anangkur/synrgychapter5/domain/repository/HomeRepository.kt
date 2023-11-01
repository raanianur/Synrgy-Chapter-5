package com.anangkur.synrgychapter5.domain.repository

import com.anangkur.synrgychapter5.domain.Movie

interface HomeRepository {
    suspend fun fetchMovies(): List<Movie>
}