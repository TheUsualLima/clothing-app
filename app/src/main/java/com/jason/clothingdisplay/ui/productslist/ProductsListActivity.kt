package com.jason.clothingdisplay.ui.productslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.jason.clothingdisplay.R
import com.jason.clothingdisplay.databinding.ActivityProductsListBinding
import com.jason.clothingdisplay.databinding.ProductsListItemBinding
import com.jason.clothingdisplay.domain.Product
import java.text.DecimalFormat

class ProductsListActivity : AppCompatActivity() {
    private lateinit var vBinding: ActivityProductsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(vBinding.root)

        setupRecycler()
    }

    private fun setupRecycler() {
        vBinding.productListRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductsAdapter()
        vBinding.productListRecyclerView.adapter = adapter
        vBinding.productListRecyclerView.setHasFixedSize(true)

        adapter.submitList(
            listOf(
                Product(
                    1,
                    "Chinos",
                    67.toBigDecimal(),
                    "chino-image"
                ),
                Product(
                    2,
                    "Fancy Shoes",
                    45.toBigDecimal(),
                    "fancy-shoes-image"
                ),
                Product(
                    3,
                    "Fluffy Jacket",
                    123.99.toBigDecimal(),
                    "fluffy-jacket-image"
                ),
                Product(
                    4,
                    "Red Shirt",
                    17.46.toBigDecimal(),
                    "red-shirt-image"
                ),
                Product(
                    5,
                    "Sandals",
                    99999.99999.toBigDecimal(),
                    "sandals-image"
                ),
                Product(
                    6,
                    "Dinosaur Costume",
                    3.50.toBigDecimal(),
                    "dinosaur-costume-image"
                ),
                Product(
                    1,
                    "Chinos",
                    67.toBigDecimal(),
                    "chino-image"
                ),
                Product(
                    2,
                    "Fancy Shoes",
                    45.toBigDecimal(),
                    "fancy-shoes-image"
                ),
                Product(
                    3,
                    "Fluffy Jacket",
                    123.99.toBigDecimal(),
                    "fluffy-jacket-image"
                ),
                Product(
                    4,
                    "Red Shirt",
                    17.46.toBigDecimal(),
                    "red-shirt-image"
                ),
                Product(
                    5,
                    "Sandals",
                    99999.99999.toBigDecimal(),
                    "sandals-image"
                ),
                Product(
                    6,
                    "Dinosaur Costume",
                    3.50.toBigDecimal(),
                    "dinosaur-costume-image"
                )
            )
        )
    }
}