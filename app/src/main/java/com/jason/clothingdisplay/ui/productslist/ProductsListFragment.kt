package com.jason.clothingdisplay.ui.productslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jason.clothingdisplay.databinding.FragmentProductsListBinding
import com.jason.clothingdisplay.presentation.productslist.ProductsListViewModel

class ProductsListFragment() : Fragment(), com.jason.clothingdisplay.ui.productslist.View {

    private var _binding: FragmentProductsListBinding? = null
    private val binding: FragmentProductsListBinding
        get() = requireNotNull(_binding)

    private lateinit var viewModel: ProductsListViewModel

    companion object {
        fun newInstance() = ProductsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductsListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductsListViewModel::class.java)
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.productListRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ProductsAdapter(this)
        binding.productListRecyclerView.adapter = adapter
        binding.productListRecyclerView.setHasFixedSize(true)
        viewModel.productsList.observe(viewLifecycleOwner, { adapter.submitList(it) })
    }

    override fun onItemClick(prodID: String) {
        TODO("Not yet implemented")
    }
}