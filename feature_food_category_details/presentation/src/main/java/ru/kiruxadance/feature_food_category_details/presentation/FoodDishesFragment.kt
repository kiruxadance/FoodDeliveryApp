package ru.kiruxadance.feature_food_category_details.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.kiruxadance.feature_food_category_details.presentation.databinding.FragmentFoodDishesBinding

@AndroidEntryPoint
class FoodDishesFragment : Fragment() {
    private var _binding: FragmentFoodDishesBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<FoodDishesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDishesBinding.inflate(inflater, container, false)
        return binding.root
    }

}