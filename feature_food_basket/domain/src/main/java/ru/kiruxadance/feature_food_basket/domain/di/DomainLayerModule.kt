package ru.kiruxadance.feature_food_basket.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_food_basket.domain.repository.FoodBasketRepository
import ru.kiruxadance.feature_food_basket.domain.use_cases.DeleteAndGetAllFoodBasketUseCase
import ru.kiruxadance.feature_food_basket.domain.use_cases.GetAllFoodBasketUseCase
import ru.kiruxadance.feature_food_basket.domain.use_cases.UpdateAndGetAllFoodBasketUseCase

@Module
@InstallIn(SingletonComponent::class)
class DomainLayerModule {
    @Provides
    fun provideUpdateAndGetAllFoodBasket(foodBasketRepository: FoodBasketRepository): UpdateAndGetAllFoodBasketUseCase {
        return UpdateAndGetAllFoodBasketUseCase(foodBasketRepository)
    }

    @Provides
    fun provideDeleteAndGetAllFoodBasket(foodBasketRepository: FoodBasketRepository): DeleteAndGetAllFoodBasketUseCase {
        return DeleteAndGetAllFoodBasketUseCase(foodBasketRepository)
    }

    @Provides
    fun provideGetAllFoodBasket(foodBasketRepository: FoodBasketRepository): GetAllFoodBasketUseCase {
        return GetAllFoodBasketUseCase(foodBasketRepository)
    }
}