package com.demo.leta.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.leta.databinding.ItemPerformanceBinding
import com.demo.leta.models.ArtistPerformance
import com.demo.leta.ui.viewHolders.PerformanceItemViewHolder
import com.demo.leta.viewModels.PerformanceItemViewModel

class PerformanceItemAdapter : RecyclerView.Adapter<PerformanceItemViewHolder>() {

    private val dataSet = mutableListOf<ArtistPerformance>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PerformanceItemViewHolder {
        val binding = ItemPerformanceBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return PerformanceItemViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: PerformanceItemViewHolder, position: Int) {
        val item = dataSet[position]
        val vm = PerformanceItemViewModel(item)
        viewHolder.onBind(vm)
    }

    fun updateItems(items: List<ArtistPerformance>) {
        dataSet.clear()
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataSet.size
}
