package com.anangkur.synrgychapter5.presentation.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.anangkur.synrgychapter5.R
import com.anangkur.synrgychapter5.databinding.ActivityHomeBinding
import com.anangkur.synrgychapter5.presentation.adapter.MovieAdapter

class HomeActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    private var binding: ActivityHomeBinding? = null
    private var movieAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setupMovieAdapter()
    }

    private fun setupMovieAdapter() {
        movieAdapter = MovieAdapter()
        binding?.recyclerMovie?.adapter = movieAdapter
        binding?.recyclerMovie?.layoutManager = LinearLayoutManager(this)
    }
}