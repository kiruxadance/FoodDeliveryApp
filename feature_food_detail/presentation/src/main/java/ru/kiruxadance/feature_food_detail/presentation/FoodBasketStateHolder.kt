package ru.kiruxadance.feature_food_detail.presentation

import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket

data class FoodBasketStateHolder(
    val isLoading: Boolean = false,
    val data: FoodBasket? = null,
    val error: String = ""
)