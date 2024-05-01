package com.demo.leta.services

import com.demo.leta.dtos.ArtistDTO
import com.demo.leta.dtos.PerformanceDTO
import com.demo.leta.dtos.VenueDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SongLeapRetrofitService {
    // Artist
    @GET("artists")
    fun getArtists(): Call<List<ArtistDTO>>

    @GET("artist/{id}")
    fun getArtist(@Path("id") id: String): Call<ArtistDTO>

    @GET("artists/{id}/performances")
    fun getArtistPerformances(
        @Path("id") id: Int,
        @Query("from") from: String?,
        @Query("to") to: String?
    ): Call<List<PerformanceDTO>>

    // Venues
    @GET("venues")
    fun getVenues(): Call<List<VenueDTO>>

    @GET("venues/{id}")
    fun getVenue(@Path("id") id: String): Call<VenueDTO>

    @GET("venues/{id}/performances")
    fun getVenuesPerformances(
        @Path("id") id: String,
        @Query("from") from: String?,
        @Query("to") to: String?
    ): Call<List<PerformanceDTO>>

    // Performances
    @GET("performances")
    fun getPerformances(
        @Query("from") from: String?,
        @Query("to") to: String?
    ): Call<List<PerformanceDTO>>

    @GET("performance/{id}")
    fun getPerformance(
        @Path("id") id: String
    ): Call<PerformanceDTO>

}