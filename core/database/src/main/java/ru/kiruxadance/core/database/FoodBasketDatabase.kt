package ru.kiruxadance.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kiruxadance.core.database.model.FoodBasketEntity

@Database(entities = [FoodBasketEntity::class], version = 1)
abstract class FoodBasketDatabase : RoomDatabase() {
    abstract fun foodBasketDao(): FoodBasketDao
}