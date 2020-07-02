package com.santiagolozada.themovies.di

import com.santiagolozada.themovies.presentations.movies.detail.DetailMovieViewModel
import com.santiagolozada.themovies.presentations.movies.main.ListMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ListMoviesViewModel(
            listMoviesUseCase = get()
        )
    }

    viewModel {
        DetailMovieViewModel(
            detailMovieUseCase = get()
        )
    }
}