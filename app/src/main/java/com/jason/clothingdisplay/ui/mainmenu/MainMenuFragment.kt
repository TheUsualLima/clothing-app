package com.jason.clothingdisplay.ui.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jason.clothingdisplay.R
import com.jason.clothingdisplay.databinding.FragmentMainMenuBinding
import com.jason.clothingdisplay.databinding.FragmentProductsListBinding

class MainMenuFragment : Fragment() {
    private var _binding: FragmentMainMenuBinding? = null
    private val binding: FragmentMainMenuBinding
        get() = requireNotNull(_binding)

    companion object {
        fun newInstance() = MainMenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewProductsButton.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToProductsListFragment()
            view.findNavController().navigate(action)
        }
    }
}