package com.jason.clothingdisplay.ui.productslist

import androidx.recyclerview.widget.DiffUtil
import com.jason.clothingdisplay.domain.network.Product

object ProductDiffUtilItemCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}