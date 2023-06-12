package ru.kiruxadance.feature_food_detail.domain.repository

import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket

interface FoodBasketRepository {
    fun insertFoodBasket(foodBasket: FoodBasket)
    fun deleteFoodBasket(foodBasket: FoodBasket)
    fun updateFoodBasket(foodBasket: FoodBasket)
    suspend fun getFoodBasketById(id: Int) : FoodBasket
}