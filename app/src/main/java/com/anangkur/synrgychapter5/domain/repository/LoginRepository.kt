package com.anangkur.synrgychapter5.domain.repository

interface LoginRepository {
    suspend fun validateInput(username: String, password: String): Boolean
    suspend fun authenticate(username: String, password: String): String
    suspend fun saveToken(token: String)
    suspend fun loadToken(): String?
}