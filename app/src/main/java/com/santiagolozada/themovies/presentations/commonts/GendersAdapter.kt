package com.santiagolozada.themovies.presentations.commonts

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiagolozada.themovies.R
import com.santiagolozada.themovies.databinding.ItemGenresBinding
import com.santiagolozada.themovies.presentations.models.GenresPresentation
import com.santiagolozada.themovies.presentations.utils.inflate
import kotlin.properties.Delegates

class GendersAdapter : RecyclerView.Adapter<GendersAdapter.ViewHolder>() {

    var genres: List<GenresPresentation> by Delegates.observable(
        emptyList(),
        { _, _, _ -> notifyDataSetChanged() }
    )

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemGenresBinding.bind(itemView)

        fun bind(genre: GenresPresentation) {
            binding.nameGenres.text = genre.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = run {
        ViewHolder(
            parent.inflate(R.layout.item_genres)
        )
    }

    override fun getItemCount(): Int = genres.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genres[position])
    }
}