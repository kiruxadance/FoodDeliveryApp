package ru.kiruxadance.core.network.data_providers

import ru.kiruxadance.core.network.ApiService
import javax.inject.Inject

class FoodDataProviders @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getFoodCategories() = apiService.getFoodCategories()
    suspend fun getFoodDishes() = apiService.getFoodDishes()
}