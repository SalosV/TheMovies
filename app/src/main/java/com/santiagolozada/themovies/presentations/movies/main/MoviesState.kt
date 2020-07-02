package com.santiagolozada.themovies.presentations.movies.main

import com.santiagolozada.themovies.presentations.models.MoviesPresentation

sealed class MoviesState {
    class Loading(val isLoading: Boolean): MoviesState()
    class ListMovies(val movies: List<MoviesPresentation>): MoviesState()
}