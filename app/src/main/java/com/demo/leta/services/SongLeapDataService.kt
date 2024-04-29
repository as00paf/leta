package com.demo.leta.services

import android.util.Log
import com.demo.leta.mappers.SongLeapDataMapper
import com.demo.leta.models.Artist
import com.demo.leta.models.Performance
import com.demo.leta.models.SongLeapApiResult
import com.demo.leta.models.Venue
import java.util.Date

class SongLeapDataService {
    private val TAG = "SongLeapDataService"

    private val apiService = SongLeapApiService()
    private val mapper = SongLeapDataMapper()

    suspend fun getArtists(): List<Artist> {
        return when (val result = apiService.getArtists()) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapArtists(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                emptyList()
            }
        }
    }

    suspend fun getArtist(id: String): Artist? {
        return when (val result = apiService.getArtist(id)) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapArtist(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                null
            }
        }
    }

    suspend fun getArtistPerformances(id: String, from: Date?, to: Date?): List<Performance> {
        return when (val result = apiService.getArtistPerformances(id, from, to)) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapPerformances(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                emptyList()
            }
        }
    }
    suspend fun getVenues(): List<Venue> {
        return when (val result = apiService.getVenues()) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapVenues(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                emptyList()
            }
        }
    }

    suspend fun getVenue(id: String): Venue? {
        return when (val result = apiService.getVenue(id)) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapVenue(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                null
            }
        }
    }

    suspend fun getVenuesPerformances(id: String, from: Date?, to: Date?): List<Performance> {
        return when (val result = apiService.getVenuePerformances(id, from, to)) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapPerformances(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                emptyList()
            }
        }
    }

    suspend fun getPerformances(from: Date?, to: Date?): List<Performance> {
        return when (val result = apiService.getPerformances(from, to)) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapPerformances(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                emptyList()
            }
        }
    }

    suspend fun getPerformance(id: String): Performance? {
        return when (val result = apiService.getPerformance(id)) {
            is SongLeapApiResult.Success -> {
                Log.d(TAG, "Data loaded : $result")
                mapper.mapPerformance(result.data)
            }
            else -> {
                Log.e(TAG, "Could not load data : $result")
                null
            }
        }
    }
}