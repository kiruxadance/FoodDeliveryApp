package ru.kiruxadance.feature_food_basket.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket
import ru.kiruxadance.feature_food_basket.domain.use_cases.DeleteAndGetAllFoodBasketUseCase
import ru.kiruxadance.feature_food_basket.domain.use_cases.GetAllFoodBasketUseCase
import ru.kiruxadance.feature_food_basket.domain.use_cases.UpdateAndGetAllFoodBasketUseCase
import javax.inject.Inject

@HiltViewModel
class FoodBasketViewModel @Inject constructor(
    private val updateAndGetAllFoodBasketUseCase: UpdateAndGetAllFoodBasketUseCase,
    private val deleteAndGetAllFoodBasketUseCase: DeleteAndGetAllFoodBasketUseCase,
    private val getAllFoodBasketUseCase: GetAllFoodBasketUseCase
): ViewModel() {

    private val _foodBasket: MutableStateFlow<FoodBasketStateHolder?> = MutableStateFlow(FoodBasketStateHolder())
    val foodBasket: StateFlow<FoodBasketStateHolder?> = _foodBasket.asStateFlow()

    fun updateAndGetFoodBasket(foodBasket: FoodBasket) = viewModelScope.launch {
        if (foodBasket.count == 0) {
            deleteAndGetAllFoodBasketUseCase(foodBasket).onEach {
                when(it) {
                    is Resource.Error -> {
                        _foodBasket.value = FoodBasketStateHolder(error = it.message.toString())
                    }
                    is Resource.Loading -> {
                        _foodBasket.value = FoodBasketStateHolder(isLoading = true)
                    }
                    is Resource.Success -> {
                        _foodBasket.value = FoodBasketStateHolder(data = it.data)
                    }
                }
            }.launchIn(viewModelScope)
        } else {
            updateAndGetAllFoodBasketUseCase(foodBasket).onEach {
                when(it) {
                    is Resource.Error -> {
                        _foodBasket.value = FoodBasketStateHolder(error = it.message.toString())
                    }
                    is Resource.Loading -> {
                        _foodBasket.value = FoodBasketStateHolder(isLoading = true)
                    }
                    is Resource.Success -> {
                        _foodBasket.value = FoodBasketStateHolder(data = it.data)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    fun getAllFoodBasket() = viewModelScope.launch {
        getAllFoodBasketUseCase().onEach {
            when(it) {
                is Resource.Error -> {
                    _foodBasket.value = FoodBasketStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _foodBasket.value = FoodBasketStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _foodBasket.value = FoodBasketStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}