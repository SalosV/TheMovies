package com.santiagolozada.themovies.di

import com.santiagolozada.themovies.data.remote.movies.DetailMovieRepositoryImp
import com.santiagolozada.themovies.data.remote.movies.MoviesRepositoryImp
import com.santiagolozada.themovies.domain.repository.DetailMovieRepository
import com.santiagolozada.themovies.domain.repository.ListMoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ListMoviesRepository> { MoviesRepositoryImp(serviceApi = get()) }
    factory<DetailMovieRepository> { DetailMovieRepositoryImp(serviceApi = get()) }
}