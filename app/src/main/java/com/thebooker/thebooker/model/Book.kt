package com.thebooker.thebooker.model

import com.google.gson.annotations.SerializedName

data class Book(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("author")
        val author: String,
        @SerializedName("coverLink")
        val coverLink: String,
        @SerializedName("user")
        val user: User,
        @SerializedName("userId")
        val userId: Int,
        @SerializedName("assignment")
        val assignment: Int,
        @SerializedName("externalBookProvider")
        val externalBookProvider: Int,
        @SerializedName("externalId")
        val externalId: String
)