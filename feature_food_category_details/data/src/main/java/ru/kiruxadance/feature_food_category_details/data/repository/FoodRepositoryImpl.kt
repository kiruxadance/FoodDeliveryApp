package ru.kiruxadance.feature_food_category_details.data.repository

import ru.kiruxadance.core.network.data_providers.FoodDataProviders
import ru.kiruxadance.feature_food_category_details.data.mapper.toDomainFoodDishesList
import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes
import ru.kiruxadance.feature_food_category_details.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDataProviders: FoodDataProviders
): FoodRepository {
    override suspend fun getFoodDishes(): List<FoodDishes> {
        return foodDataProviders.getFoodDishes().toDomainFoodDishesList()
    }
}