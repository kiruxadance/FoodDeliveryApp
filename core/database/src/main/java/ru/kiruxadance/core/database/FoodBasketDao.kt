package ru.kiruxadance.core.database

import androidx.room.*
import ru.kiruxadance.core.database.model.FoodBasketEntity

@Dao
interface FoodBasketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFoodBasket(foodBasketEntity: FoodBasketEntity)

    @Delete
    fun deleteFoodBasket(foodBasketEntity: FoodBasketEntity)

    @Update
    fun updateFoodBasket(foodBasketEntity: FoodBasketEntity)

    @Query("SELECT * FROM FoodBasketEntity")
    suspend fun getAllFoodBaskets(): List<FoodBasketEntity>

    @Query("SELECT * FROM FoodBasketEntity WHERE id=:id ")
    suspend fun getFoodBasketById(id: Int): FoodBasketEntity
}