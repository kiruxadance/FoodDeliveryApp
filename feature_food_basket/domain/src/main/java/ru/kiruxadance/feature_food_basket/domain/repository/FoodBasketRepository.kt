package ru.kiruxadance.feature_food_basket.domain.repository

import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket

interface FoodBasketRepository {
    fun updateFoodBasket(foodBasket: FoodBasket)
    fun deleteFoodBasket(foodBasket: FoodBasket)
    suspend fun getAllFoodBasket(): List<FoodBasket>
}