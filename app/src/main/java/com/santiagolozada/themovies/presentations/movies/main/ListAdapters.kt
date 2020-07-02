package com.santiagolozada.themovies.presentations.movies.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiagolozada.themovies.R
import com.santiagolozada.themovies.databinding.ItemListBinding
import com.santiagolozada.themovies.presentations.movies.main.ListAdapters.ViewHolder
import com.santiagolozada.themovies.presentations.models.MoviesPresentation
import com.santiagolozada.themovies.presentations.utils.inflate
import com.santiagolozada.themovies.presentations.utils.loadUrl
import kotlin.properties.Delegates

class ListAdapters(
    private val itemSelect: (MoviesPresentation) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    var movies: List<MoviesPresentation> by Delegates.observable(
        arrayListOf(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = run {
        ViewHolder(parent.inflate(R.layout.item_list))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], itemSelect)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemListBinding.bind(itemView)

        fun bind(movie: MoviesPresentation, itemSelect: (MoviesPresentation) -> Unit) {

            binding.title.text = movie.tile

            movie.posterPath?.let { urlImage ->
                binding.photo.loadUrl(urlImage)
            }

            itemView.setOnClickListener {
                itemSelect(movie)
            }
        }
    }
}