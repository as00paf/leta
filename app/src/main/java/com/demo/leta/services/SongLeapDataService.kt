package com.demo.leta.services

import android.util.Log
import com.demo.leta.mappers.SongLeapDataMapper
import com.demo.leta.models.Artist
import com.demo.leta.models.ArtistPerformance
import com.demo.leta.models.SongLeapApiResult
import java.util.Calendar
import java.util.Date

class SongLeapDataService {
    private val apiService = SongLeapApiService()
    private val mapper = SongLeapDataMapper()
    suspend fun getArtists(): List<Artist> {
        return when (val result = apiService.getArtists()) {
            is SongLeapApiResult.Success -> mapper.mapArtists(result.data)
            else -> {
                Log.e(TAG, "Could not load artists : $result")
                emptyList()
            }
        }
    }

    suspend fun getArtistPerformances(artist: Artist): List<ArtistPerformance> {
        val result = apiService.getArtistPerformances(artist.id, Date(), twoWeeksFromNow())
        return when (result) {
            is SongLeapApiResult.Success -> mapper.mapArtistPerformances(artist, result.data)
            else -> {
                Log.e(TAG, "Could not load performances : $result")
                emptyList()
            }
        }
    }

    private fun twoWeeksFromNow(): Date {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, 13)
        return cal.time
    }
}

private const val TAG = "SongLeapDataService"