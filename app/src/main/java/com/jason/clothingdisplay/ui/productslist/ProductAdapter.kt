package com.jason.clothingdisplay.ui.productslist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jason.clothingdisplay.R
import com.jason.clothingdisplay.databinding.ProductsListItemBinding
import com.jason.clothingdisplay.domain.network.Product

class ProductsAdapter() : ListAdapter<Product, ProductsAdapter.ProductsViewHolder>(ProductDiffUtilItemCallback) {
    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemBinding = ProductsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(itemBinding, parent.context)
    }

    class ProductsViewHolder(private val itemBinding: ProductsListItemBinding, private val context: Context) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(currentItem: Product) {
            itemBinding.apply {
                productName.text = currentItem.name
                productPrice.text = context.resources.getString(R.string.price, String.format("%.2f", currentItem.price))
                val url = "https://riverisland.scene7.com/is/image/RiverIsland/${currentItem.id}_main"
                Glide.with(context)
                    .load(url)
                    .transition(DrawableTransitionOptions.withCrossFade(750))
                    .centerCrop()
                    .placeholder(null)
                    .error(R.drawable.ic_launcher_background)
                    .into(productImage)

                productItemContainer.setOnClickListener {
                    Toast.makeText(context, "${currentItem.name} clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}