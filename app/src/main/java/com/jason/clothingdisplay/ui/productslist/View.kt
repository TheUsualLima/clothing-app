package com.jason.clothingdisplay.ui.productslist

import com.jason.clothingdisplay.domain.network.Product

interface View {
    fun onItemClick(product: Product)
}