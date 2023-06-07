package ru.kiruxadance.feature_food_search.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.kiruxadance.feature_food_search.presentation.databinding.FragmentFoodSearchBinding

@AndroidEntryPoint
class FoodSearchFragment : Fragment() {

    private var _binding: FragmentFoodSearchBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<FoodSearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}