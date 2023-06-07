package ru.kiruxadance.feature_food_category_details.data.mapper

import ru.kiruxadance.core.network.model.FoodDishesResponse
import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes

fun FoodDishesResponse.toDomainFoodDishesList(): List<FoodDishes> {
    return this.dishes.map {
        FoodDishes(
            description = it.description,
            id = it.id,
            image_url = it.image_url,
            name = it.name,
            price = it.price,
            tegs = it.tegs,
            weight = it.weight
        )
    }
}