package com.santiagolozada.themovies.domain.usecases

import com.santiagolozada.themovies.domain.repository.DetailMovieRepository

class DetailMovieUseCase(
    private val detailMovieRepository: DetailMovieRepository
) {

    suspend fun getDetailMovie(movieId: Int) = detailMovieRepository.getDetailMovie(movieId)
}