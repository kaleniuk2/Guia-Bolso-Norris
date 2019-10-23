package com.kaleniuk2.guiabolsonorris.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("created_at")
    val created_at: String,

    @SerializedName("icon_url")
    val icon_url: String,

    @SerializedName("updated_at")
    val updated_at: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("value")
    val value: String
)