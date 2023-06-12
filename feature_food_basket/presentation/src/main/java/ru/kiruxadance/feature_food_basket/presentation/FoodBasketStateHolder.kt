package ru.kiruxadance.feature_food_basket.presentation

import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket

data class FoodBasketStateHolder(
    val isLoading: Boolean = false,
    val data: List<FoodBasket>? = null,
    val error: String = ""
)