package ru.kiruxadance.feature_food_category_details.domain.model

data class FoodDishes(
    val description: String,
    val id: Int,
    val image_url: String?,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
)