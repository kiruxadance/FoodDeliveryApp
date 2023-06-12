package ru.kiruxadance.feature_food_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket
import ru.kiruxadance.feature_food_detail.domain.use_cases.DeleteAndGetFoodBasketUseCase
import ru.kiruxadance.feature_food_detail.domain.use_cases.GetFoodBasketByIdUseCase
import ru.kiruxadance.feature_food_detail.domain.use_cases.InsertAndGetFoodBasketUseCase
import ru.kiruxadance.feature_food_detail.domain.use_cases.UpdateAndGetFoodBasketUseCase
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val insertAndGetFoodBasketUseCase: InsertAndGetFoodBasketUseCase,
    private val deleteAndGetFoodBasketUseCase: DeleteAndGetFoodBasketUseCase,
    private val updateAndGetFoodBasketUseCase: UpdateAndGetFoodBasketUseCase,
    private val getFoodBasketByIdUseCase: GetFoodBasketByIdUseCase
) : ViewModel(){

    private val _foodBasket: MutableStateFlow<FoodBasketStateHolder?> = MutableStateFlow(FoodBasketStateHolder())
    val foodBasket: StateFlow<FoodBasketStateHolder?> = _foodBasket.asStateFlow()

    fun insertAndGetFoodBasket(foodBasket: FoodBasket) = viewModelScope.launch {
        insertAndGetFoodBasketUseCase(foodBasket).onEach {
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

    fun updateAndGetFoodBasket(foodBasket: FoodBasket) = viewModelScope.launch {
        if (foodBasket.count == 0) {
            deleteAndGetFoodBasketUseCase(foodBasket).onEach {
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
            updateAndGetFoodBasketUseCase(foodBasket).onEach {
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

    fun getFoodBasketById(id: Int) = viewModelScope.launch {
        getFoodBasketByIdUseCase(id).onEach {
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