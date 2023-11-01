package com.anangkur.synrgychapter5.presentation.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anangkur.synrgychapter5.data.local.LocalRepository
import com.anangkur.synrgychapter5.databinding.ActivityLoginBinding
import com.anangkur.synrgychapter5.presentation.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    private var viewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = createViewModel()

        observeViewModel()

        viewModel?.checkLogin()

        binding?.buttonLogin?.setOnClickListener {
            viewModel?.authenticate(
                username = binding?.etUsername?.text?.toString().orEmpty(),
                password = binding?.etPassword?.text?.toString().orEmpty(),
            )
        }
    }

    private fun createViewModel(): LoginViewModel {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginViewModel(
                    loginRepository = LocalRepository(
                        sharedPreferences = getSharedPreferences(
                            LocalRepository.PREF_NAME,
                            MODE_PRIVATE,
                        ),
                    )
                ) as T
            }
        }.create(LoginViewModel::class.java)
    }

    private fun observeViewModel() {
        viewModel?.authentication?.observe(this, ::handleAuthentication)
        viewModel?.error?.observe(this, ::handleError)
        viewModel?.loading?.observe(this, ::handleLoading)
    }

    private fun handleAuthentication(token: String) {
        if (token.isNotEmpty() && token.isNotBlank()) {
            viewModel?.saveToken(token)
            HomeActivity.startActivity(this)
            this.finish()
        }
    }

    private fun handleError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun handleLoading(isLoading: Boolean) {
        binding?.buttonLogin?.visibility = if (isLoading) View.GONE else View.VISIBLE
        binding?.progress?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}