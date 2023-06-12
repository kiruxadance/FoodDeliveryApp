package ru.kiruxadance.feature_food_category_details.presentation

import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes

data class ChipDishesStateHolder(
    val dishes: MutableList<String> = mutableListOf("Все меню")
)
