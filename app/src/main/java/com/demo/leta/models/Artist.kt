package com.demo.leta.models

import android.os.Bundle
import com.demo.leta.AppConsts

data class Artist(
    val id: Int,
    val genre: String,
    val name: String,
    val imageUrl: String
)

fun Artist.toBundle(): Bundle =
    Bundle().apply {
        putInt(AppConsts.ID, id)
        putString(AppConsts.NAME, name)
        putString(AppConsts.GENRE, genre)
        putString(AppConsts.IMAGE_URL, imageUrl)
    }

fun Bundle.getArtistFromBundle(): Artist =
    Artist(
        getInt(AppConsts.ID),
        getString(AppConsts.GENRE).orEmpty(),
        getString(AppConsts.NAME).orEmpty(),
        getString(AppConsts.IMAGE_URL).orEmpty()
    )

