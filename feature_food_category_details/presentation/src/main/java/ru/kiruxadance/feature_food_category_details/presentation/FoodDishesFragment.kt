package ru.kiruxadance.feature_food_category_details.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        binding.foodDishesRecyclerView.layoutManager = GridLayoutManager(this.context, 3)
        val adapter = FoodDishesRecyclerAdapter(listOf())
        binding.foodDishesRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chipSalads.setOnCheckedChangeListener {chip, isChecked ->
           if (isChecked) viewModel.setChipDishes(chip.text.toString())
           else viewModel.removeChipDishes(chip.text.toString())
        }

        binding.chipWithFish.setOnCheckedChangeListener {chip, isChecked ->
            if (isChecked) viewModel.setChipDishes(chip.text.toString())
            else viewModel.removeChipDishes(chip.text.toString())
        }

        binding.chipWithRice.setOnCheckedChangeListener {chip, isChecked ->
            if (isChecked) viewModel.setChipDishes(chip.text.toString())
            else viewModel.removeChipDishes(chip.text.toString())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            /*viewModel.foodDishesList.collectLatest {
                it?.let {
                    if (it.isLoading) {

                    }
                    if (it.error.isNotBlank()) {

                    }
                    it.data?.let {foodDishes ->
                        val adapter = FoodDishesRecyclerAdapter(foodDishes)
                        adapter.setOnItemClickListener(object : FoodDishesRecyclerAdapter.OnItemClickListener{
                            override fun onItemClick(position: Int) {
                                val bundle = Bundle()
                                val gson = Gson()
                                bundle.putSerializable("food", gson.toJson(foodDishes[position]))
                                findNavController().navigate(ru.kiruxadance.navigation.R.id.action_foodDishesFragment_to_foodDetailDialogFragment, bundle)
                            }
                        })
                        binding.foodDishesRecyclerView.adapter = adapter
                    }
                }
            }*/

        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sortedDishesList.collectLatest {
                it?.let {
                    it.data.let {foodDishes ->
                        val adapter = FoodDishesRecyclerAdapter(foodDishes!!)
                        adapter.setOnItemClickListener(object : FoodDishesRecyclerAdapter.OnItemClickListener{
                            override fun onItemClick(position: Int) {
                                val bundle = Bundle()
                                val gson = Gson()
                                bundle.putSerializable("food", gson.toJson(foodDishes[position]))
                                findNavController().navigate(ru.kiruxadance.navigation.R.id.action_foodDishesFragment_to_foodDetailDialogFragment, bundle)
                            }
                        })
                        binding.foodDishesRecyclerView.adapter = adapter
                    }
                }
            }
        }
    }

}