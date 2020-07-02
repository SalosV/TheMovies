package com.santiagolozada.themovies.presentations.mappers

import com.santiagolozada.themovies.domain.models.DetailMovieDomain
import com.santiagolozada.themovies.domain.models.GenresDomain
import com.santiagolozada.themovies.domain.models.MovieDomain
import com.santiagolozada.themovies.presentations.models.DetailMoviePresentation
import com.santiagolozada.themovies.presentations.models.GenresPresentation
import com.santiagolozada.themovies.presentations.models.MoviesPresentation


fun MovieDomain.toPresenter() = MoviesPresentation(
    id = id,
    tile = title,
    posterPath = posterPath
)

fun DetailMovieDomain.toPresenter() = DetailMoviePresentation(
    id,
    backdropPath,
    homepage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    video,
    voteAverage,
    voteCount,
    genres.map { it.toPresentation() }
)

fun GenresDomain.toPresentation() = GenresPresentation(
    id,
    name
)