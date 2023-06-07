package ru.kiruxadance.feature_food_category_details.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.kiruxadance.feature_food_category_details.domain.use_cases.GetFoodDishesUseCase
import javax.inject.Inject

@HiltViewModel
class FoodDishesViewModel @Inject constructor(
    private val getFoodDishesUseCase: GetFoodDishesUseCase
): ViewModel() {

}