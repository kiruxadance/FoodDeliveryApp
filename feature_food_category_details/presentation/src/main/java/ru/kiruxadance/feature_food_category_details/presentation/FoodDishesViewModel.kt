package ru.kiruxadance.feature_food_category_details.presentation

import android.widget.CompoundButton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_category_details.domain.use_cases.GetFoodDishesUseCase
import javax.inject.Inject

@HiltViewModel
class FoodDishesViewModel @Inject constructor(
    private val getFoodDishesUseCase: GetFoodDishesUseCase
): ViewModel() {
    private val _foodDishesList: MutableStateFlow<FoodDishesStateHolder?> = MutableStateFlow(FoodDishesStateHolder())
    val foodDishesList: StateFlow<FoodDishesStateHolder?> = _foodDishesList.asStateFlow()

    private val _chipDishesList: MutableStateFlow<ChipDishesStateHolder?> = MutableStateFlow(ChipDishesStateHolder())
    val chipDishesList: StateFlow<ChipDishesStateHolder?> = _chipDishesList.asStateFlow()

    private val _sortedDishesList: MutableStateFlow<SortedFoodDishesStateHolder?> = MutableStateFlow(SortedFoodDishesStateHolder())
    val sortedDishesList: StateFlow<SortedFoodDishesStateHolder?> = _sortedDishesList.asStateFlow()
    init {
        viewModelScope.launch {
            getFoodDishes()
        }
    }
    fun setChipDishes(text: String) {
        _chipDishesList.update { _chipDishesList.value?.dishes?.plus(text)
            ?.let { it1 -> it?.copy(dishes = it1.toMutableList()) } }
        updateSortedDishes()
    }

    fun removeChipDishes(text: String) {
        _chipDishesList.update {
            _chipDishesList.value?.dishes?.minus(text)?.let { it1 -> it?.copy(dishes = it1.toMutableList()) }
        }
        updateSortedDishes()
    }

    private fun updateSortedDishes() {
        _sortedDishesList.value = SortedFoodDishesStateHolder(data = emptyList())
        _foodDishesList.value?.data.let {
            for((index, value ) in it!!.withIndex()) {
                var countMatched = 0
                value.tegs.forEach {tegs ->
                    _chipDishesList.value!!.dishes.forEach { dishes ->
                        if (tegs == dishes) countMatched += 1
                    }
                }
                if (countMatched == _chipDishesList.value!!.dishes.size)
                    _sortedDishesList.update {
                        _sortedDishesList.value?.data?.plus(value).let { it1 -> it?.copy(data = it1!!.toMutableList()) }
                    }
            }
        }
    }
    private fun getFoodDishes() = viewModelScope.launch {
        getFoodDishesUseCase().onEach {
            when(it) {
                is Resource.Error -> {
                    _foodDishesList.value = FoodDishesStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _foodDishesList.value = FoodDishesStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _foodDishesList.value = FoodDishesStateHolder(data = it.data)
                    updateSortedDishes()
                }
            }
        }.launchIn(viewModelScope)
    }
}