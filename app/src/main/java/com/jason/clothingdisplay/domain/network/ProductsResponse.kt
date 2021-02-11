package com.jason.clothingdisplay.domain.network

import android.util.Log
import com.google.gson.annotations.SerializedName

class ProductsResponse(
    @SerializedName("Products")
    var products: List<Product>
)