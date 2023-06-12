package ru.kiruxadance.core.database.data_providers

import ru.kiruxadance.core.database.FoodBasketDatabase
import ru.kiruxadance.core.database.model.FoodBasketEntity
import javax.inject.Inject

class FoodBasketDataProviders @Inject constructor(
    private val db: FoodBasketDatabase
) {
    fun insertFoodBasket(foodBasketEntity: FoodBasketEntity) {
        db.foodBasketDao().insertFoodBasket(foodBasketEntity)
    }

    fun deleteFoodBasket(foodBasketEntity: FoodBasketEntity) {
        db.foodBasketDao().deleteFoodBasket(foodBasketEntity)
    }

    fun updateFoodBasket(foodBasketEntity: FoodBasketEntity) {
        db.foodBasketDao().updateFoodBasket(foodBasketEntity)
    }

    suspend fun getAllFoodBaskets() = db.foodBasketDao().getAllFoodBaskets()

    suspend fun getFoodBasketById(id: Int) = db.foodBasketDao().getFoodBasketById(id)
}