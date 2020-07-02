package com.santiagolozada.themovies.presentations.models

data class DetailMoviePresentation(
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
    val genres: List<GenresPresentation>
)