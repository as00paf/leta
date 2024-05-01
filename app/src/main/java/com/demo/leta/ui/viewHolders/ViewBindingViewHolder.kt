package com.demo.leta.ui.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.demo.leta.BR

open class ViewBindingViewHolder<T : ViewModel>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    open fun onBind(viewModel: T) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
    }
}
