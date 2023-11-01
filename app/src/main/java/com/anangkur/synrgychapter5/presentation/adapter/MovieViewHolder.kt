package com.anangkur.synrgychapter5.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.anangkur.synrgychapter5.databinding.ItemMovieBinding
import com.anangkur.synrgychapter5.domain.Movie

class MovieViewHolder(
    private val binding: ItemMovieBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.tvTitleMovie.text = movie.originalTitle
        binding.tvDescMovie.text = movie.overview
        binding.ivMovie.load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
    }
}