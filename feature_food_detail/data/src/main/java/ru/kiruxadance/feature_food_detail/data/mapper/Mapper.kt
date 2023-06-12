package ru.kiruxadance.feature_food_detail.data.mapper

import ru.kiruxadance.core.database.model.FoodBasketEntity
import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket

fun FoodBasketEntity.toDomainFoodBasket(): FoodBasket {
    return FoodBasket(
        description = this.description,
        id = this.id,
        image_url = this.image_url,
        name = this.name,
        price = this.price,
        weight = this.weight,
        count = this.count
    )
}

fun FoodBasket.toFoodBasketEntity(): FoodBasketEntity {
    return FoodBasketEntity(
        description = this.description,
        id = this.id,
        image_url = this.image_url,
        name = this.name,
        price = this.price,
        weight = this.weight,
        count = this.count
    )
}