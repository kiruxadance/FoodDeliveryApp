package ru.kiruxadance.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodBasketEntity(
    val description: String,
    @PrimaryKey val id: Int,
    val image_url: String?,
    val name: String,
    val price: Int,
    val weight: Int,
    val count: Int
)
