package com.santiagolozada.themovies.presentations.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.santiagolozada.themovies.domain.usecases.DetailMovieUseCase
import com.santiagolozada.themovies.presentations.mappers.toPresenter
import com.santiagolozada.themovies.presentations.utils.ScopedViewModel
import kotlinx.coroutines.launch

class DetailMovieViewModel(
    private val detailMovieUseCase: DetailMovieUseCase
) : ScopedViewModel() {

    private val _mutableLiveMovie = MutableLiveData<DetailMovieState>()
    val liveDataMovie: LiveData<DetailMovieState>
        get() = _mutableLiveMovie

    init {
        initScope()
    }

    fun getDetailMovie(movieId: Int) {
        launch {
            _mutableLiveMovie.value = DetailMovieState.Loading(true)
            _mutableLiveMovie.value = DetailMovieState.ShowDetailMovil(detailMovieUseCase.getDetailMovie(movieId).toPresenter())
            _mutableLiveMovie.value = DetailMovieState.Loading(false)
        }
    }
}