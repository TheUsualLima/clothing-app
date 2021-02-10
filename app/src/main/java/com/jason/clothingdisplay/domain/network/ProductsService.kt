package com.jason.clothingdisplay.domain.network

import retrofit2.Call
import retrofit2.http.GET

interface ProductsService {
    @GET("/v1/plp/en_gb/2506/products.json")
    suspend fun getProductsList(): ProductsResponse
}