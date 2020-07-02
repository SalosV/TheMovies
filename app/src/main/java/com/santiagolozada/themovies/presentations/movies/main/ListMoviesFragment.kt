package com.santiagolozada.themovies.presentations.movies.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiagolozada.themovies.R
import com.santiagolozada.themovies.databinding.FragmentListBinding
import com.santiagolozada.themovies.presentations.NavHostActivity
import com.santiagolozada.themovies.presentations.movies.detail.DetailMovieActivity
import com.santiagolozada.themovies.presentations.movies.main.MoviesState.ListMovies
import com.santiagolozada.themovies.presentations.movies.main.MoviesState.Loading
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment() {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()
    private lateinit var navHostActivity: NavHostActivity
    private lateinit var binding: FragmentListBinding

    private lateinit var moviesAdapter: ListAdapters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = run {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(inflater.context),
            R.layout.fragment_list,
            container,
            false
        )

        binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observables()
    }

    private fun initRecycler() {

        binding.list.layoutManager = LinearLayoutManager(navHostActivity)
        moviesAdapter =
            ListAdapters { movie ->
                val intent = Intent(navHostActivity, DetailMovieActivity::class.java).apply {
                    putExtra("movieId", movie.id)
                }

                startActivity(intent)
            }

        binding.list.adapter = moviesAdapter

        binding.swipeList.setOnRefreshListener {
            listMoviesViewModel.getMoviesPopular()
        }
    }

    private fun observables() {
        listMoviesViewModel.liveDataMovies.observe(navHostActivity, Observer {
            renderState(it)
        })
    }

    private fun renderState(state: MoviesState) {

        when (state) {
            is Loading -> {
                binding.swipeList.isRefreshing = state.isLoading
            }
            is ListMovies -> {
                moviesAdapter.movies = state.movies
            }
        }
    }

    override fun onResume() {
        super.onResume()
        listMoviesViewModel.getMoviesPopular()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navHostActivity = context as NavHostActivity
    }
}