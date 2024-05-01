package com.demo.leta.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.leta.models.Artist
import com.demo.leta.models.ArtistPerformance
import com.demo.leta.ui.adapters.ArtistItemAdapter
import com.demo.leta.ui.adapters.PerformanceItemAdapter

@BindingAdapter("artistList")
fun setArtistList(view: RecyclerView?, items: List<Artist>?) {
    view ?: return
    if (view.adapter == null) {
        view.layoutManager = GridLayoutManager(view.context, 2)
        view.adapter = ArtistItemAdapter()
    }

    (view.adapter as? ArtistItemAdapter)?.updateItems(items.orEmpty())
}

@BindingAdapter("performanceList")
fun setPerformanceList(view: RecyclerView?, items: List<ArtistPerformance>?) {
    if (view == null) return
    if (view.adapter == null) {
        view.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        view.adapter = PerformanceItemAdapter()
    }

    (view.adapter as? PerformanceItemAdapter)?.updateItems(items.orEmpty())
}

@BindingAdapter("imageUrl")
fun setImage(view: ImageView?, url: String) {
    if (view == null) return
    Glide.with(view.context).load(url).into(view)
}