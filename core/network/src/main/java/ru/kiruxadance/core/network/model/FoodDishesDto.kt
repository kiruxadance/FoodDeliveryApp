package ru.kiruxadance.core.network.model

data class FoodDishesDto(
    val description: String,
    val id: Int,
    val image_url: String?,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
)