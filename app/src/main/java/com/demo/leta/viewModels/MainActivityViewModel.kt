package com.demo.leta.viewModels

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.demo.leta.models.Artist
import com.demo.leta.services.SongLeapDataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ObservableViewModel() {

    private val dataService = SongLeapDataService()
    private var isLoading = false
    val artistList = ObservableArrayList<Artist>()

    fun loadData() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            val result = dataService.getArtists()
            artistList.clear()
            artistList.addAll(result)
        }

        isLoading = false
    }
}