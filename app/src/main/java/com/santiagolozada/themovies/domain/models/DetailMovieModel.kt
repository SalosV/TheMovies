package com.santiagolozada.themovies.domain.models

data class DetailMovieDomain(
    val id: Int,
    val backdropPath: String,
    val homepage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    val posterPath: String,
    val video: Boolean,
    val voteAverage: Float,
    val voteCount: Int,
    val genres: List<GenresDomain>
)