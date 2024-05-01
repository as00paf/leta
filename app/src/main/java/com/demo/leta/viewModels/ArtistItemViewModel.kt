package com.demo.leta.viewModels

import androidx.databinding.ObservableField
import com.demo.leta.models.Artist

class ArtistItemViewModel(val artist: Artist) : ObservableViewModel() {
    val name = ObservableField(artist.name)
    val imageUrl = ObservableField(artist.imageUrl)
}