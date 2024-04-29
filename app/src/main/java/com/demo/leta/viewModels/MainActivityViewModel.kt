package com.demo.leta.viewModels

import android.util.Log
import com.demo.leta.services.SongLeapApiService
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.demo.leta.models.SongLeapApiResult
import kotlinx.coroutines.launch

class MainActivityViewModel: ObservableViewModel() {


    private val apiService = SongLeapApiService()
    private var isLoading = false

    fun loadData() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = apiService.getArtists()) {
                is SongLeapApiResult.Success -> Log.d("MainActVm", "Data loaded : $result")
                else -> {
                    Log.e("MainActVm", "Could not load data : $result")
                }
            }

            isLoading = false
        }
    }
}