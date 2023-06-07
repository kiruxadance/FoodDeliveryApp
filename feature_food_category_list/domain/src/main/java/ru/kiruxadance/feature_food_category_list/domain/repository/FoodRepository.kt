package ru.kiruxadance.feature_food_category_list.domain.repository

import ru.kiruxadance.feature_food_category_list.domain.model.FoodCategory

interface FoodRepository {
    suspend fun getFoodCategories(): List<FoodCategory>
}