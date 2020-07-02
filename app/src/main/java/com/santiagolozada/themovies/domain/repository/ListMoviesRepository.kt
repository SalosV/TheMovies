package com.santiagolozada.themovies.domain.repository

import com.santiagolozada.themovies.domain.models.MovieDomain

interface ListMoviesRepository {

    suspend fun getMoviesPopular(): List<MovieDomain>
    suspend fun getMoviesTopRated(): List<MovieDomain>
}