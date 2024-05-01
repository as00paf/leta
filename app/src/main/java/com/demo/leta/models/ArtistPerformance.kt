package com.demo.leta.models

import java.util.Date

data class ArtistPerformance(
    val id: Int,
    val date: Date,
    val artist: Artist,
    val venue: Venue
)
