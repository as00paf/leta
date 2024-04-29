package com.demo.leta.mappers

import com.demo.leta.dtos.ArtistDTO
import com.demo.leta.dtos.PerformanceDTO
import com.demo.leta.dtos.VenueDTO
import com.demo.leta.models.Artist
import com.demo.leta.models.Performance
import com.demo.leta.models.Venue
import java.net.URLEncoder
import java.nio.charset.Charset

class SongLeapDataMapper {
    private val ARTIST_IMAGE_URL = "https://songleap.s3.amazonaws.com/artists/"
    private val VENUE_IMAGE_URL = "https://songleap.s3.amazonaws.com/venues/"

    fun mapArtist(dto: ArtistDTO): Artist = Artist(dto.id, dto.genre, dto.name, formatArtistImageUrl(dto))
    fun mapArtists(dto: List<ArtistDTO>): List<Artist> = dto.map { mapArtist(it) }
    fun mapVenue(dto: VenueDTO): Venue = Venue(dto.id, dto.sortId, dto.name)
    fun mapVenues(dto: List<VenueDTO>): List<Venue> = dto.map { mapVenue(it) }
    fun mapPerformance(dto: PerformanceDTO): Performance = Performance(dto.id, dto.artistId, dto.date, dto.venueId)
    fun mapPerformances(dto: List<PerformanceDTO>): List<Performance> = dto.map { mapPerformance(it) }

    private fun formatArtistImageUrl(artist: ArtistDTO) :String {
        return "$ARTIST_IMAGE_URL${artist.name.urlEncode()}.png"
    }

    private fun formatVenueImageUrl(venue: VenueDTO) :String {
        return "$ARTIST_IMAGE_URL${venue.name.urlEncode()}.png"
    }

    private fun String.urlEncode():String = URLEncoder.encode(this, "utf-8")
}