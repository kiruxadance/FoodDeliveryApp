package ru.kiruxadance.feature_food_category_list.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_food_category_list.domain.repository.FoodRepository
import ru.kiruxadance.feature_food_category_list.domain.use_cases.GetFoodCategoriesUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideGetFoodCategoriesUseCase(foodRepository: FoodRepository): GetFoodCategoriesUseCase {
        return GetFoodCategoriesUseCase(foodRepository)
    }
}