package ru.kiruxadance.feature_food_detail.domain.model

data class FoodDetail(
    val description: String,
    val id: Int,
    val image_url: String?,
    val name: String,
    val price: Int,
    val weight: Int
)