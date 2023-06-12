package ru.kiruxadance.feature_food_category_details.presentation

import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes

data class SortedFoodDishesStateHolder(
    val data: List<FoodDishes>? = emptyList(),
)
