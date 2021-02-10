package com.jason.clothingdisplay.ui.productslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jason.clothingdisplay.databinding.ActivityProductsListBinding
import com.jason.clothingdisplay.presentation.productslist.ProductsListViewModel
import com.jason.clothingdisplay.presentation.productslist.ProductsListViewModelFactory

class ProductsListActivity : AppCompatActivity() {
    private lateinit var vBinding: ActivityProductsListBinding
    private lateinit var viewModel: ProductsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(vBinding.root)

        viewModel = ViewModelProvider(this, ProductsListViewModelFactory()).get(ProductsListViewModel::class.java)
        setupRecycler()
    }

    private fun setupRecycler() {
        vBinding.productListRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductsAdapter()
        vBinding.productListRecyclerView.adapter = adapter
        vBinding.productListRecyclerView.setHasFixedSize(true)
        viewModel.productsList.observe(this, { adapter.submitList(it) })
    }
}