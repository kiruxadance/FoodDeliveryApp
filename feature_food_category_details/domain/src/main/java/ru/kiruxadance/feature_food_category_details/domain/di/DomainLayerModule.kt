package ru.kiruxadance.feature_food_category_details.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_food_category_details.domain.repository.FoodRepository
import ru.kiruxadance.feature_food_category_details.domain.use_cases.GetFoodDishesUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideGetFoodDishesUseCase(foodRepository: FoodRepository): GetFoodDishesUseCase {
        return GetFoodDishesUseCase(foodRepository)
    }
}