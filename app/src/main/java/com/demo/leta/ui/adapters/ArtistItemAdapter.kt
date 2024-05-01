package com.demo.leta.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.leta.databinding.ItemArtistBinding
import com.demo.leta.models.Artist
import com.demo.leta.ui.viewHolders.ArtistItemViewHolder
import com.demo.leta.viewModels.ArtistItemViewModel

class ArtistItemAdapter : RecyclerView.Adapter<ArtistItemViewHolder>() {

    private val dataSet = mutableListOf<Artist>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArtistItemViewHolder {
        val binding = ItemArtistBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ArtistItemViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ArtistItemViewHolder, position: Int) {
        val item = dataSet[position]
        val vm = ArtistItemViewModel(item)
        viewHolder.onBind(vm)
    }

    fun updateItems(items: List<Artist>) {
        dataSet.clear()
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataSet.size
}
