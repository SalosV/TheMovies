package com.santiagolozada.themovies.presentations.movies.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiagolozada.themovies.databinding.ActivityDetailMovieBinding
import com.santiagolozada.themovies.presentations.commonts.GendersAdapter
import com.santiagolozada.themovies.presentations.movies.detail.DetailMovieState.Loading
import com.santiagolozada.themovies.presentations.movies.detail.DetailMovieState.ShowDetailMovil
import com.santiagolozada.themovies.presentations.utils.loadUrl
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private val gendersAdapter by lazy { GendersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.extras?.getInt("movieId") ?: 0

        detailMovieViewModel.getDetailMovie(movieId)

        initRecyclers()
        observers()
    }

    private fun initRecyclers() {
        binding.genresList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.genresList.adapter = gendersAdapter
    }

    private fun observers() {
        detailMovieViewModel.liveDataMovie.observe(this, Observer {
            renderState(it)
        })

        binding.returnView.setOnClickListener { onBackPressed() }
    }

    private fun renderState(movieState: DetailMovieState) {

        when (movieState) {
            is Loading -> {
                if (movieState.isLoading)
                    binding.progress.show()
                else
                    binding.progress.hide()
            }
            is ShowDetailMovil -> {
                movieState.detailMovie.apply {

                    binding.movieImage.loadUrl(posterPath)
                    binding.moviePortada.loadUrl(backdropPath)
                    binding.titleMovie.text = originalTitle
                    binding.popularity.rating = voteAverage.div(2)
                    gendersAdapter.genres = genres
                    binding.detailSypnosis.text = overview
                }
            }
        }
    }
}