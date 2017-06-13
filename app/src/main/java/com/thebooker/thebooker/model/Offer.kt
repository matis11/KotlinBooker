package com.thebooker.thebooker.model

import com.google.gson.annotations.SerializedName

data class Offer(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("bookGenre")
        val bookGenre: String,
        @SerializedName("bookGenreId")
        val bookGenreId: Int,
        @SerializedName("bookTitle")
        val bookTitle: String,
        @SerializedName("bookAuthor")
        val bookAuthor: String,
        @SerializedName("bookCoverLink")
        val bookCoverLink: String
)
