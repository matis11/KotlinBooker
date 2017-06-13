package com.thebooker.thebooker.model

import com.google.gson.annotations.SerializedName

data class Match(
        @SerializedName("sourceUser")
        val sourceUser: User?,
        @SerializedName("sourceUserBook")
        val sourceUserBook: Book?,
        @SerializedName("targetUser")
        val targetUser: User?,
        @SerializedName("targetUserBook")
        val targetUserBook: Book?,
        @SerializedName("offer")
        val offer: Offer?
)