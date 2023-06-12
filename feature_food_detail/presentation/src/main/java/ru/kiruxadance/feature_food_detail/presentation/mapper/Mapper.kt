package ru.kiruxadance.feature_food_detail.presentation.mapper

import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket
import ru.kiruxadance.feature_food_detail.domain.model.FoodDetail

fun FoodDetail.toFoodBasket(count: Int): FoodBasket {
    return FoodBasket(
        description = this.description,
        id = this.id,
        image_url = this.image_url,
        name = this.name,
        price = this.price,
        weight = this.weight,
        count = count
    )
}