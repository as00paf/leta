package com.demo.leta.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.leta.models.Artist

@BindingAdapter("artistList")
fun setArtistList(view: RecyclerView?, items: List<Artist>?) {
    if(view==null) return
    if(view.adapter == null) {
        view.layoutManager = GridLayoutManager(view.context, 2)
        val adapter = ArtistItemAdapter()
        view.adapter = adapter
    }

    (view.adapter as? ArtistItemAdapter)?.updateItems(items.orEmpty())
}

@BindingAdapter("imageUrl")
fun setImage(view: ImageView?, url:String) {
    if(view == null) return
    Glide.with(view.context).load(url).into(view)
}