package com.demo.leta.mappers

import com.demo.leta.AppConsts.ARTIST_IMAGE_URL
import com.demo.leta.AppConsts.VENUE_IMAGE_URL
import com.demo.leta.dtos.ArtistDTO
import com.demo.leta.dtos.PerformanceDTO
import com.demo.leta.dtos.VenueDTO
import com.demo.leta.models.Artist
import com.demo.leta.models.ArtistPerformance
import com.demo.leta.models.Venue
import java.net.URLEncoder

class SongLeapDataMapper {
    fun mapArtist(dto: ArtistDTO): Artist =
        Artist(dto.id, dto.genre, dto.name, formatArtistImageUrl(dto))

    fun mapArtists(dto: List<ArtistDTO>): List<Artist> = dto.map { mapArtist(it) }

    fun mapArtistPerformances(
        artist: Artist,
        performances: List<PerformanceDTO>
    ): List<ArtistPerformance> =
        performances.map { performance ->
            ArtistPerformance(performance.id, performance.date, artist, mapVenue(performance.venue))
        }

    fun mapVenue(dto: VenueDTO): Venue =
        Venue(dto.id, dto.sortId, dto.name, formatVenueImageUrl(dto))

    private fun formatArtistImageUrl(artist: ArtistDTO): String =
        "$ARTIST_IMAGE_URL${artist.name.urlEncode()}.png"

    private fun formatVenueImageUrl(venue: VenueDTO): String =
        "$VENUE_IMAGE_URL${venue.name.urlEncode()}.png"

    private fun String.urlEncode(): String = URLEncoder.encode(this, "utf-8")
}