package com.example.assignment_007.model

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("token")
    val token: String
)
