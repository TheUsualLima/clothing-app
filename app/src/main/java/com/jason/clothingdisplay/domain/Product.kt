package com.jason.clothingdisplay.domain

import java.math.BigDecimal

data class Product(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val image: String
) {
}