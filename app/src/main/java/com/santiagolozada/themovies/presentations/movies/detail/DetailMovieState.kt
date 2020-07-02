package com.santiagolozada.themovies.presentations.movies.detail

import com.santiagolozada.themovies.presentations.models.DetailMoviePresentation

sealed class DetailMovieState{
    class Loading(val isLoading: Boolean): DetailMovieState()
    class ShowDetailMovil(val detailMovie: DetailMoviePresentation): DetailMovieState()
}