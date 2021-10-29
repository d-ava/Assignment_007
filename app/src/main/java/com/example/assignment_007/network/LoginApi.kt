package com.example.assignment_007.network

import com.example.assignment_007.model.User
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApi {
    @POST("login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,

    ): User
}