package ru.kiruxadance.feature_food_category_list.data.mapper

import ru.kiruxadance.core.network.model.FoodCategoriesResponse
import ru.kiruxadance.feature_food_category_list.domain.model.FoodCategory

fun FoodCategoriesResponse.toDomainFoodCategoriesList(): List<FoodCategory> {
    return this.сategories.map {
        FoodCategory(
            id = it.id,
            image_url = it.image_url,
            name = it.name
        )
    }
}