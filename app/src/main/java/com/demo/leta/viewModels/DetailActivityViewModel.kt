package com.demo.leta.viewModels

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.demo.leta.models.Artist
import com.demo.leta.models.ArtistPerformance
import com.demo.leta.services.SongLeapDataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivityViewModel : ObservableViewModel() {

    private val dataService = SongLeapDataService()
    val performanceList = ObservableArrayList<ArtistPerformance>()

    fun loadData(artist: Artist) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dataService.getArtistPerformances(artist)
            performanceList.clear()
            performanceList.addAll(result.sortedBy { it.date })
        }
    }
}