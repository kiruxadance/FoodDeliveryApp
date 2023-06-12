package ru.kiruxadance.feature_food_basket.domain.model

data class FoodBasket(
    val description: String,
    val id: Int,
    val image_url: String?,
    val name: String,
    val price: Int,
    val weight: Int,
    var count: Int
    )
