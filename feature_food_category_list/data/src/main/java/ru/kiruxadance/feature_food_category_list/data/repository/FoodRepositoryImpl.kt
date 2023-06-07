package ru.kiruxadance.feature_food_category_list.data.repository

import ru.kiruxadance.core.network.data_providers.FoodDataProviders
import ru.kiruxadance.feature_food_category_list.data.mapper.toDomainFoodCategoriesList
import ru.kiruxadance.feature_food_category_list.domain.model.FoodCategory
import ru.kiruxadance.feature_food_category_list.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDataProviders: FoodDataProviders
) : FoodRepository {

    override suspend fun getFoodCategories(): List<FoodCategory> {
        return foodDataProviders.getFoodCategories().toDomainFoodCategoriesList()
    }
}