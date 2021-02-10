package com.jason.clothingdisplay.ui.productdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.jason.clothingdisplay.R
import com.jason.clothingdisplay.databinding.ProductDetailsFragmentBinding

class ProductDetailsFragment(private val prodID: String) : Fragment() {

    private var _binding: ProductDetailsFragmentBinding? = null
    private val binding: ProductDetailsFragmentBinding
        get() = requireNotNull(_binding)

    companion object {
        fun newInstance(prodID: String) = ProductDetailsFragment(prodID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProductDetailsFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "https://riverisland.scene7.com/is/image/RiverIsland/${prodID}_main"
        Glide.with(requireContext())
            .load(url)
            .override(SIZE_ORIGINAL)
            .apply(
                RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888)
            )
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.productDetailsImage)
    }
}