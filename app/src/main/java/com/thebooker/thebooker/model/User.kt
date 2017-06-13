package com.thebooker.thebooker.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("id")
        val id: Int,
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("secondName")
        val secondName: String,
        @SerializedName("password")
        val password: String
)