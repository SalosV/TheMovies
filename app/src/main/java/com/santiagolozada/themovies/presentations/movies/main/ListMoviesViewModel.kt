package com.santiagolozada.themovies.presentations.movies.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.santiagolozada.themovies.domain.usecases.ListMoviesUseCase
import com.santiagolozada.themovies.presentations.mappers.toPresenter
import com.santiagolozada.themovies.presentations.movies.main.MoviesState.ListMovies
import com.santiagolozada.themovies.presentations.movies.main.MoviesState.Loading
import com.santiagolozada.themovies.presentations.utils.ScopedViewModel
import kotlinx.coroutines.launch

class ListMoviesViewModel(
    private val listMoviesUseCase: ListMoviesUseCase
) : ScopedViewModel() {

    private val _mutableLiveDataMovies = MutableLiveData<MoviesState>()
    val liveDataMovies: LiveData<MoviesState>
        get() = _mutableLiveDataMovies

    init {
        initScope()
    }

    fun getMoviesPopular() {
        launch {
            _mutableLiveDataMovies.value = Loading(true)
            _mutableLiveDataMovies.value =
                ListMovies(listMoviesUseCase.getMoviesPopular().map { it.toPresenter() })
            _mutableLiveDataMovies.value = Loading(false)
        }
    }

    fun getMoviesTopRated() {
        launch {
            _mutableLiveDataMovies.value = Loading(true)
            _mutableLiveDataMovies.value =
                ListMovies(listMoviesUseCase.getMoviesTopRated().map { it.toPresenter() })
            _mutableLiveDataMovies.value = Loading(false)
        }
    }
}