package com.anangkur.synrgychapter5.data.remote

import com.anangkur.synrgychapter5.data.remote.response.toMovie
import com.anangkur.synrgychapter5.data.remote.service.TMDBService
import com.anangkur.synrgychapter5.domain.Movie
import com.anangkur.synrgychapter5.domain.repository.HomeRepository
import kotlinx.coroutines.delay

class RemoteRepository(
    private val tmdbService: TMDBService,
) : HomeRepository {
    override suspend fun fetchMovies(): List<Movie> {
        return tmdbService.fetchMovies().results?.map { result -> result.toMovie() }.orEmpty()
    }
}