package ru.kiruxadance.feature_food_category_details.domain.repository

import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes

interface FoodRepository {
    suspend fun getFoodDishes(): List<FoodDishes>
}