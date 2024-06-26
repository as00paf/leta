package com.demo.leta.viewModels

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.demo.leta.models.Artist
import com.demo.leta.services.SongLeapDataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ObservableViewModel() {

    private val dataService = SongLeapDataService()
    val artistList = ObservableArrayList<Artist>()

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dataService.getArtists()
            artistList.clear()
            artistList.addAll(result.sortedBy { it.name })
        }
    }
}