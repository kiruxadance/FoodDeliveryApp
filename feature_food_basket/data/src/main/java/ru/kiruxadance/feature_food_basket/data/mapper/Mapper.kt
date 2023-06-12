package ru.kiruxadance.feature_food_basket.data.mapper

import ru.kiruxadance.core.database.model.FoodBasketEntity
import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket

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

fun List<FoodBasketEntity>.toDomainFoodBasketList(): List<FoodBasket>{
    return this.map {
        FoodBasket(
            description = it.description,
            id = it.id,
            image_url = it.image_url,
            name = it.name,
            price = it.price,
            weight = it.weight,
            count = it.count
        )
    }
}