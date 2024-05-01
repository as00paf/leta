package com.demo.leta.ui.viewHolders

import android.content.Intent
import com.demo.leta.AppConsts
import com.demo.leta.databinding.ItemArtistBinding
import com.demo.leta.models.toBundle
import com.demo.leta.ui.activities.DetailActivity
import com.demo.leta.viewModels.ArtistItemViewModel

class ArtistItemViewHolder(private val binding: ItemArtistBinding) :
    ViewBindingViewHolder<ArtistItemViewModel>(binding) {
    override fun onBind(viewModel: ArtistItemViewModel) {
        super.onBind(viewModel)
        binding.root.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(AppConsts.ARTIST, viewModel.artist.toBundle())
            it.context.startActivity(intent)
        }
    }
}
