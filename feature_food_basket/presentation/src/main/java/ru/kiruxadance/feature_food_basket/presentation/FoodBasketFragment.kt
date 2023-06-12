package ru.kiruxadance.feature_food_basket.presentation

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
import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket
import ru.kiruxadance.feature_food_basket.presentation.databinding.FragmentFoodBasketBinding

@AndroidEntryPoint
class FoodBasketFragment : Fragment() {

    private var _binding: FragmentFoodBasketBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<FoodBasketViewModel>()

    private lateinit var currentFoodBasket: FoodBasket

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodBasketBinding.inflate(inflater, container, false)
        binding.foodBasketRecyclerView.layoutManager = LinearLayoutManager(this.context)
        val adapter = FoodBasketRecyclerAdapter(listOf())
        binding.foodBasketRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllFoodBasket()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.foodBasket.collectLatest {
                it?.let {
                    if (it.isLoading) {

                    }
                    if (it.error.isNotBlank()) {
                        Log.d("error: ", it.error)
                    }
                    it.data?.let {
                        binding.buttonPayment.text = "Оплатить ${getPrice(foodBaskets = it)} ₽"
                        val adapter = FoodBasketRecyclerAdapter(it)
                        adapter.setOnItemClickListener(object : FoodBasketRecyclerAdapter.OnItemClickListener {
                            override fun onItemClick(position: Int) {
                                val bundle = Bundle()
                                val gson = Gson()
                                bundle.putSerializable("food", gson.toJson(it[position]))
                                findNavController().navigate(ru.kiruxadance.navigation.R.id.action_navigation_basket_to_foodDetailDialogFragment, bundle)
                            }
                        })
                        adapter.setOnMinusItemClickListener(object : FoodBasketRecyclerAdapter.OnItemClickListener {
                            override fun onItemClick(position: Int) {
                                currentFoodBasket = it[position]
                                currentFoodBasket.count = currentFoodBasket.count - 1
                                viewModel.updateAndGetFoodBasket(currentFoodBasket)
                            }
                        })
                        adapter.setOnPlusItemClickListener(object : FoodBasketRecyclerAdapter.OnItemClickListener {
                            override fun onItemClick(position: Int) {
                                currentFoodBasket = it[position]
                                currentFoodBasket.count = currentFoodBasket.count + 1
                                viewModel.updateAndGetFoodBasket(currentFoodBasket)
                            }
                        })
                        binding.foodBasketRecyclerView.adapter = adapter
                    }
                }
            }
        }
    }

    private fun getPrice(foodBaskets: List<FoodBasket>): String {
        var price = 0
        foodBaskets.forEach {
            val sum = it.count * it.price
            price += sum
        }
        return price.toString()
    }
}