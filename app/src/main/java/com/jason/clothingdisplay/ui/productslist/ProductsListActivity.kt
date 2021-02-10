package com.jason.clothingdisplay.ui.productslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jason.clothingdisplay.R
import com.jason.clothingdisplay.databinding.ActivityProductsListBinding

class ProductsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFragment = ProductsListFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()

        
    }

}