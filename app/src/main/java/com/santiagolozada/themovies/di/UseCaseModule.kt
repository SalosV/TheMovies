package com.santiagolozada.themovies.di

import com.santiagolozada.themovies.domain.usecases.DetailMovieUseCase
import com.santiagolozada.themovies.domain.usecases.ListMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { ListMoviesUseCase(listMoviesRepository = get()) }
    factory {
        DetailMovieUseCase(
            detailMovieRepository = get()
        )
    }
}