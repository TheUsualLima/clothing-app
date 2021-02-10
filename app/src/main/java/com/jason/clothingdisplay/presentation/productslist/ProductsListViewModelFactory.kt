package com.jason.clothingdisplay.presentation.productslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductsListViewModelFactory: ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsListViewModel() as T
    }
}