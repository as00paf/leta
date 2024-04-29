package com.demo.leta.models

import java.util.Date

data class Performance(
    val id: Int,
    val artistId: Int,
    val date: Date,
    val venueId: Int
)
