package com.jason.clothingdisplay.ui.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.jason.clothingdisplay.R
import com.jason.clothingdisplay.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment() : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding: FragmentProductDetailsBinding
        get() = requireNotNull(_binding)
    val args: ProductDetailsFragmentArgs by navArgs()

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prodID = args.productId

        val url = "https://riverisland.scene7.com/is/image/RiverIsland/${prodID}_main"
        val progressSpinner = CircularProgressDrawable(requireContext())
        progressSpinner.strokeWidth = 15f
        progressSpinner.centerRadius = 100f
        progressSpinner.start()

        Glide.with(requireContext())
            .load(url)
            .apply(
                RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888)
            )
            .placeholder(progressSpinner)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.productDetailsImage)
    }
}