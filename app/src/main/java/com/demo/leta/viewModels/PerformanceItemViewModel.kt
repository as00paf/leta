package com.demo.leta.viewModels

import androidx.databinding.ObservableField
import com.demo.leta.models.ArtistPerformance
import java.text.SimpleDateFormat
import java.util.Locale

class PerformanceItemViewModel(val performance: ArtistPerformance) : ObservableViewModel() {
    private val dateFormatter = SimpleDateFormat("EEEE, MMM d yyyy'@'h:mm a", Locale.getDefault())

    val venueName = ObservableField(performance.venue.name)
    val venueImageUrl = ObservableField(performance.venue.imageUrl)
    val date = ObservableField(dateFormatter.format(performance.date))
}