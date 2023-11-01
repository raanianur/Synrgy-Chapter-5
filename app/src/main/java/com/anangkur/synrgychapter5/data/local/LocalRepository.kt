package com.anangkur.synrgychapter5.data.local

import android.content.SharedPreferences
import com.anangkur.synrgychapter5.domain.repository.LoginRepository
import kotlinx.coroutines.delay

class LocalRepository(
    private val sharedPreferences: SharedPreferences,
) : LoginRepository {

    companion object {
        private const val KEY_TOKEN = "token"
        const val PREF_NAME = "sharedPref"
    }

    override suspend fun validateInput(username: String, password: String): Boolean {
        delay(1000)
        return username.isNotEmpty()
                && username.isNotBlank()
                && password.isNotEmpty()
                && password.isNotBlank()
    }

    override suspend fun authenticate(username: String, password: String): String {
        delay(1000)
        return if (username == "anangkur" && password == "123456") {
            "token"
        } else {
            throw UnsupportedOperationException("username dan password salah!")
        }
    }

    override suspend fun saveToken(token: String) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
    }

    override suspend fun loadToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }
}