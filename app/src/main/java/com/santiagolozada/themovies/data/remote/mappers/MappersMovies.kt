package com.santiagolozada.themovies.data.remote.mappers

import com.santiagolozada.themovies.data.Utils.URL_IMAGES
import com.santiagolozada.themovies.data.remote.models.Genres as GenresData
import com.santiagolozada.themovies.domain.models.DetailMovieDomain
import com.santiagolozada.themovies.domain.models.GenresDomain
import com.santiagolozada.themovies.data.remote.models.DetailMovie as DetailMovieData
import com.santiagolozada.themovies.domain.models.MovieDomain
import com.santiagolozada.themovies.data.remote.models.Movie as MovieData


fun MovieData.toDomain() = MovieDomain(
    id,
    "${URL_IMAGES}${posterPath}",
    adult,
    overview,
    releaseDate,
    originalTitle,
    originalLanguage,
    title,
    backdropPath,
    popularity,
    voteCount,
    video,
    voteAverage
)

fun DetailMovieData.toDomain() = DetailMovieDomain(
    id,
    "${URL_IMAGES}${backdropPath}",
    homepage,
    originalTitle,
    overview,
    popularity,
    "${URL_IMAGES}${posterPath}",
    video,
    voteAverage,
    voteCount,
    genres.map { it.toDomain() }
)

fun GenresData.toDomain() = GenresDomain(
    id,
    name
)