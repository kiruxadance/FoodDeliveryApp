package ru.kiruxadance.core.network

import retrofit2.http.GET
import ru.kiruxadance.core.network.model.FoodCategoriesResponse
import ru.kiruxadance.core.network.model.FoodDishesResponse

interface ApiService {
    @GET("v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getFoodCategories(): FoodCategoriesResponse

    @GET("v3/c7a508f2-a904-498a-8539-09d96785446e")
    suspend fun getFoodDishes(): FoodDishesResponse
}