package com.anangkur.synrgychapter5.presentation.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anangkur.synrgychapter5.R
import com.anangkur.synrgychapter5.data.local.LocalRepository
import com.anangkur.synrgychapter5.data.remote.RemoteRepository
import com.anangkur.synrgychapter5.databinding.ActivityHomeBinding
import com.anangkur.synrgychapter5.domain.Movie
import com.anangkur.synrgychapter5.presentation.adapter.MovieAdapter
import com.anangkur.synrgychapter5.presentation.auth.login.LoginViewModel

class HomeActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    private var binding: ActivityHomeBinding? = null
    private var movieAdapter: MovieAdapter? = null
    private var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = createViewModel()

        observeLiveData()
        setupMovieAdapter()

        viewModel?.fetchMovies()
    }

    private fun setupMovieAdapter() {
        movieAdapter = MovieAdapter()
        binding?.recyclerMovie?.adapter = movieAdapter
        binding?.recyclerMovie?.layoutManager = LinearLayoutManager(this)
    }

    private fun createViewModel(): HomeViewModel {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(
                    homeRepository = RemoteRepository(),
                ) as T
            }
        }.create(HomeViewModel::class.java)
    }

    private fun observeLiveData() {
        viewModel?.loading?.observe(this, ::handleLoading)
        viewModel?.error?.observe(this, ::handleError)
        viewModel?.movies?.observe(this, ::handleMovies)
    }

    private fun handleLoading(isLoading: Boolean) {
        binding?.progress?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun handleError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun handleMovies(movies: List<Movie>) {
        movieAdapter?.submitList(movies)
    }
}