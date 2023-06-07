package ru.kiruxadance.feature_food_category_list.presentation

import ru.kiruxadance.feature_food_category_list.domain.model.FoodCategory

data class FoodCategoriesStateHolder(
    val isLoading: Boolean = false,
    val data: List<FoodCategory>? = null,
    val error: String = ""
)