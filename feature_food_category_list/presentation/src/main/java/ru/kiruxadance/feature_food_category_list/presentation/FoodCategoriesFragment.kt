package ru.kiruxadance.feature_food_category_list.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.kiruxadance.feature_food_category_list.presentation.databinding.FragmentFoodCategoriesBinding

@AndroidEntryPoint
class FoodCategoriesFragment : Fragment() {
    private var _binding: FragmentFoodCategoriesBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<FoodCategoriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodCategoriesBinding.inflate(inflater, container, false)
        binding.foodCategoriesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.foodCategoryList.collectLatest {
                it?.let {
                    if (it.isLoading) {

                    }

                    if (it.error.isNotBlank()) {

                    }

                    it.data?.let {
                        val adapter = FoodCategoriesRecyclerAdapter(it)
                        adapter.setOnItemClickListener(object : FoodCategoriesRecyclerAdapter.OnItemClickListener{
                            override fun onItemClick(position: Int) {
                                
                            }
                        })
                        binding.foodCategoriesRecyclerView.adapter = adapter
                    }
                }
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}