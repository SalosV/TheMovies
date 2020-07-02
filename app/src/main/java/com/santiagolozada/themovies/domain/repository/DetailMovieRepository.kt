package com.santiagolozada.themovies.domain.repository

import com.santiagolozada.themovies.domain.models.DetailMovieDomain

interface DetailMovieRepository {
    suspend fun getDetailMovie(movieId: Int): DetailMovieDomain
}