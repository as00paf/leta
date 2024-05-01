package com.demo.leta.dtos

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PerformanceDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("artistId") val artistId: Int,
    @SerializedName("date") val date: Date,
    @SerializedName("venue") val venue: VenueDTO
)