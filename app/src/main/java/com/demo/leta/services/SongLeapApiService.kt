package com.demo.leta.services

import android.util.Log
import com.demo.leta.dtos.ArtistDTO
import com.demo.leta.dtos.PerformanceDTO
import com.demo.leta.dtos.VenueDTO
import com.demo.leta.models.SongLeapApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date

const val SONG_LEAP_BASE_URL = "http://ec2-54-160-91-114.compute-1.amazonaws.com/"

class SongLeapApiService {
    private val interceptor =
        HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }

    private val retrofit = Retrofit.Builder()
        .baseUrl(SONG_LEAP_BASE_URL)
        .client(OkHttpClient().newBuilder().addInterceptor(interceptor).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(SongLeapRetrofitService::class.java)


    // Artists
    suspend fun getArtists(): SongLeapApiResult<List<ArtistDTO>> = callApi { service.getArtists() }

    suspend fun getArtist(id: String): SongLeapApiResult<ArtistDTO> =
        callApi { service.getArtist(id) }

    suspend fun getArtistPerformances(id: String, from: Date?, to: Date?): SongLeapApiResult<List<PerformanceDTO>> =
        callApi { service.getArtistPerformances(id, from, to) }

    // Venues
    suspend fun getVenues(): SongLeapApiResult<List<VenueDTO>> = callApi { service.getVenues() }

    suspend fun getVenue(id: String): SongLeapApiResult<VenueDTO> = callApi { service.getVenue(id) }

    suspend fun getVenuePerformances(id: String, from: Date?, to: Date?): SongLeapApiResult<List<PerformanceDTO>> = callApi { service.getVenuesPerformances(id, from, to) }

    // Performances
    suspend fun getPerformances(from: Date?, to: Date?): SongLeapApiResult<List<PerformanceDTO>> = callApi { service.getPerformances(from, to) }

    suspend fun getPerformance(id: String): SongLeapApiResult<PerformanceDTO> = callApi { service.getPerformance(id) }


    private suspend fun <T> callApi(call: () -> Call<T>): SongLeapApiResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = call.invoke().execute()
                if (response.isSuccessful) {
                    Log.d("SongLeapApiService", "Success: ${response.body()}")
                    val data = response.body()
                    if (data != null) SongLeapApiResult.Success(data)
                    else SongLeapApiResult.ApiError("Data is null")
                } else {
                    Log.d("SongLeapApiService", "Error: ${response.message()}")
                    SongLeapApiResult.ApiError(response.message())
                }
            } catch (e: Exception) {
                Log.e("SongLeapApiService", "Error: $e")
                SongLeapApiResult.NetworkError(e.message.orEmpty(), e)
            }
        }
    }
}