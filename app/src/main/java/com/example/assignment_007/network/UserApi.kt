package com.example.assignment_007.network

import com.example.assignment_007.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {


    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String,

        ): Response<User>


    @FormUrlEncoded
    @POST("register")
    suspend fun userRegister(
        @Field("email") email: String,
        @Field("password") password: String,

    ): Response<User>


}
