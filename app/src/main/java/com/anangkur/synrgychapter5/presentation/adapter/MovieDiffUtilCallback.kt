package com.anangkur.synrgychapter5.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.anangkur.synrgychapter5.domain.Movie

class MovieDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }
}