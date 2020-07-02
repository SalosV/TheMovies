package com.santiagolozada.themovies.data.remote.movies

import com.santiagolozada.themovies.data.Utils.API_KEY
import com.santiagolozada.themovies.data.Utils.LANGUAGE
import com.santiagolozada.themovies.data.network.ServiceApi
import com.santiagolozada.themovies.data.remote.mappers.toDomain
import com.santiagolozada.themovies.domain.repository.DetailMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailMovieRepositoryImp(
    private val serviceApi: ServiceApi
) : DetailMovieRepository {

    override suspend fun getDetailMovie(movieId: Int) = withContext(Dispatchers.IO) {
        val result = serviceApi.getDetailMovie(movieId, API_KEY, LANGUAGE)

        result.toDomain()
    }
}