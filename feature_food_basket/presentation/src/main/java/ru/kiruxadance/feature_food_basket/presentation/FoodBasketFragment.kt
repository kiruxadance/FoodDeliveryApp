package ru.kiruxadance.feature_food_basket.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.kiruxadance.feature_food_basket.presentation.databinding.FragmentFoodBasketBinding

@AndroidEntryPoint
class FoodBasketFragment : Fragment() {

    private var _binding: FragmentFoodBasketBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<FoodBasketViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodBasketBinding.inflate(inflater, container, false)
        return binding.root
    }
}