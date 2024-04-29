package com.demo.leta.dtos

import com.google.gson.annotations.SerializedName

data class VenueDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("sortId") val sortId: Int,
    @SerializedName("name") val name: String
)