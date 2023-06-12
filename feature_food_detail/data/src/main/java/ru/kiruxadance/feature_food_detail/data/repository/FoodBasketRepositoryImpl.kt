package ru.kiruxadance.feature_food_detail.data.repository

import ru.kiruxadance.core.database.data_providers.FoodBasketDataProviders
import ru.kiruxadance.feature_food_detail.data.mapper.toDomainFoodBasket
import ru.kiruxadance.feature_food_detail.data.mapper.toFoodBasketEntity
import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket
import ru.kiruxadance.feature_food_detail.domain.repository.FoodBasketRepository
import javax.inject.Inject

class FoodBasketRepositoryImpl @Inject constructor(
    private val foodBasketDataProviders: FoodBasketDataProviders
): FoodBasketRepository {
    override fun insertFoodBasket(foodBasket: FoodBasket) {
        foodBasketDataProviders.insertFoodBasket(foodBasket.toFoodBasketEntity())
    }

    override fun deleteFoodBasket(foodBasket: FoodBasket) {
        foodBasketDataProviders.deleteFoodBasket(foodBasket.toFoodBasketEntity())
    }

    override fun updateFoodBasket(foodBasket: FoodBasket) {
        foodBasketDataProviders.updateFoodBasket(foodBasket.toFoodBasketEntity())
    }

    override suspend fun getFoodBasketById(id: Int): FoodBasket {
        return foodBasketDataProviders.getFoodBasketById(id).toDomainFoodBasket()
    }
}