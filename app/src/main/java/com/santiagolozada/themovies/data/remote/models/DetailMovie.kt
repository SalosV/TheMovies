package com.santiagolozada.themovies.data.remote.models

import com.google.gson.annotations.SerializedName

data class DetailMovie(
    val id: Int,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val homepage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    @SerializedName("poster_path")
    val posterPath: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Float,
    @SerializedName("vote_count")
    val voteCount: Int,
    val genres: List<Genres>
)