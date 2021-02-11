package com.jason.clothingdisplay.domain.network

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Product(
    @SerializedName("prodid")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("cost")
    val price: BigDecimal
)