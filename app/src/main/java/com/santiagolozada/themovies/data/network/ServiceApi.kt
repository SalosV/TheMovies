package com.santiagolozada.themovies.data.network

import com.santiagolozada.themovies.data.remote.models.DetailMovie
import com.santiagolozada.themovies.data.remote.models.Movie
import com.santiagolozada.themovies.data.remote.models.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("/3/movie/popular")
    suspend fun getMoviesPopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") limit: Int
    ): Response<Movie>

    @GET("/3/movie/{movieId}")
    suspend fun getDetailMovie(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): DetailMovie
}