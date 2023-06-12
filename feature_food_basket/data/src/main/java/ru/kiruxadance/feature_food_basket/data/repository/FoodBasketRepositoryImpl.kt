package ru.kiruxadance.feature_food_basket.data.repository

import ru.kiruxadance.core.database.data_providers.FoodBasketDataProviders
import ru.kiruxadance.feature_food_basket.data.mapper.toDomainFoodBasketList
import ru.kiruxadance.feature_food_basket.data.mapper.toFoodBasketEntity
import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket
import ru.kiruxadance.feature_food_basket.domain.repository.FoodBasketRepository
import javax.inject.Inject

class FoodBasketRepositoryImpl @Inject constructor(
    private val foodBasketDataProviders: FoodBasketDataProviders
): FoodBasketRepository {
    override fun updateFoodBasket(foodBasket: FoodBasket) {
        foodBasketDataProviders.updateFoodBasket(foodBasket.toFoodBasketEntity())
    }

    override fun deleteFoodBasket(foodBasket: FoodBasket) {
        foodBasketDataProviders.deleteFoodBasket(foodBasket.toFoodBasketEntity())
    }

    override suspend fun getAllFoodBasket(): List<FoodBasket> {
        return foodBasketDataProviders.getAllFoodBaskets().toDomainFoodBasketList()
    }
}