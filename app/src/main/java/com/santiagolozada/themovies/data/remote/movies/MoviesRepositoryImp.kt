package com.santiagolozada.themovies.data.remote.movies

import com.santiagolozada.themovies.data.Utils.API_KEY
import com.santiagolozada.themovies.data.Utils.LANGUAGE
import com.santiagolozada.themovies.data.Utils.LIMIT
import com.santiagolozada.themovies.data.network.ServiceApi
import com.santiagolozada.themovies.data.remote.mappers.toDomain
import com.santiagolozada.themovies.domain.models.MovieDomain
import com.santiagolozada.themovies.domain.repository.ListMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImp(
    private val serviceApi: ServiceApi
) : ListMoviesRepository {

    override suspend fun getMoviesPopular() = withContext(Dispatchers.IO) {
        val result = serviceApi.getMoviesPopular(API_KEY, LANGUAGE, LIMIT)

        result.results.map {
            it.toDomain()
        }
    }

    override suspend fun getMoviesTopRated(): List<MovieDomain> = withContext(Dispatchers.IO) {

        val result = serviceApi.getMoviesTopRated(API_KEY, LANGUAGE, LIMIT)

        result.results.map {
            it.toDomain()
        }
    }

}