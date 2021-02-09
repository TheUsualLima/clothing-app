package com.jason.clothingdisplay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jason.clothingdisplay.ui.productslist.ProductsListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewProductsButton = findViewById<Button>(R.id.view_products_button)
        viewProductsButton.setOnClickListener{
            val viewProductsIntent = Intent(this, ProductsListActivity::class.java)
            startActivity(viewProductsIntent)
        }
    }
}