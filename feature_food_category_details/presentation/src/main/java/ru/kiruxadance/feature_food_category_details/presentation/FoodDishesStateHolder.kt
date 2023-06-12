package ru.kiruxadance.feature_food_category_details.presentation

import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes

data class FoodDishesStateHolder(
    val isLoading: Boolean = false,
    val data: List<FoodDishes>? = null,
    val error: String = ""
)