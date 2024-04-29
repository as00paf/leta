package com.demo.leta.dtos

import com.google.gson.annotations.SerializedName

data class ArtistDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("genre") val genre: String,
    @SerializedName("name") val name: String
)