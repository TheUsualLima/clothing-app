package com.jason.clothingdisplay.presentation.productslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.jason.clothingdisplay.domain.network.Product
import com.jason.clothingdisplay.domain.network.ProductsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsListViewModel : ViewModel() {
    private val _productsList = MutableLiveData<List<Product>>()
    val productsList : LiveData<List<Product>> = _productsList

    init {
        val service = Retrofit.Builder()
            .baseUrl("https://static-ri.ristack-3.nn4maws.net/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ProductsService::class.java)

        viewModelScope.launch(Dispatchers.IO) {
            val response = service.getProductsList()
            _productsList.postValue(response.products)
        }
    }
}