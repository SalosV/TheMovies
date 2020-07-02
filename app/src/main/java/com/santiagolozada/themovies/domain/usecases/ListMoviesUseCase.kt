package com.santiagolozada.themovies.domain.usecases

import com.santiagolozada.themovies.domain.repository.ListMoviesRepository

class ListMoviesUseCase(
    private val listMoviesRepository: ListMoviesRepository
) {
    suspend fun getMoviesPopular() =
        listMoviesRepository.getMoviesPopular()

    suspend fun getMoviesTopRated() =
        listMoviesRepository.getMoviesTopRated()
}