package com.demo.leta.services

import android.util.Log
import com.demo.leta.AppConsts.SONG_LEAP_BASE_URL
import com.demo.leta.dtos.ArtistDTO
import com.demo.leta.dtos.PerformanceDTO
import com.demo.leta.models.SongLeapApiResult
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SongLeapApiService {
    private val interceptor =
        HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }

    private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(SONG_LEAP_BASE_URL)
        .client(OkHttpClient().newBuilder().addInterceptor(interceptor).build())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val service = retrofit.create(SongLeapRetrofitService::class.java)

    private val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    suspend fun getArtists(): SongLeapApiResult<List<ArtistDTO>> = callApi { service.getArtists() }
    suspend fun getArtistPerformances(
        id: Int,
        from: Date,
        to: Date
    ): SongLeapApiResult<List<PerformanceDTO>> =
        callApi {
            service.getArtistPerformances(
                id,
                dateFormatter.format(from),
                dateFormatter.format(to)
            )
        }

    private suspend fun <T> callApi(call: () -> Call<T>): SongLeapApiResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = call.invoke().execute()
                if (response.isSuccessful) {
                    Log.d(TAG, "Success: ${response.body()}")
                    val data = response.body()
                    if (data != null) SongLeapApiResult.Success(data)
                    else SongLeapApiResult.ApiError("Data is null")
                } else {
                    Log.d(TAG, "Error: ${response.message()}")
                    SongLeapApiResult.ApiError(response.message())
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error: $e")
                SongLeapApiResult.NetworkError(e.message.orEmpty(), e)
            }
        }
    }
}

private const val TAG = "SongLeapApiService"