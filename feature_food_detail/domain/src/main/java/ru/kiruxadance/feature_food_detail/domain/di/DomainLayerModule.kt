package ru.kiruxadance.feature_food_detail.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_food_detail.domain.repository.FoodBasketRepository
import ru.kiruxadance.feature_food_detail.domain.use_cases.DeleteAndGetFoodBasketUseCase
import ru.kiruxadance.feature_food_detail.domain.use_cases.GetFoodBasketByIdUseCase
import ru.kiruxadance.feature_food_detail.domain.use_cases.InsertAndGetFoodBasketUseCase
import ru.kiruxadance.feature_food_detail.domain.use_cases.UpdateAndGetFoodBasketUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideInsertAndGetFoodBasketUseCase(foodBasketRepository: FoodBasketRepository): InsertAndGetFoodBasketUseCase {
        return InsertAndGetFoodBasketUseCase(foodBasketRepository)
    }

    @Provides
    fun provideUpdateAndGetFoodBasketUseCase(foodBasketRepository: FoodBasketRepository): UpdateAndGetFoodBasketUseCase {
        return UpdateAndGetFoodBasketUseCase(foodBasketRepository)
    }

    @Provides
    fun provideDeleteAndGetFoodBasketUseCase(foodBasketRepository: FoodBasketRepository): DeleteAndGetFoodBasketUseCase {
        return DeleteAndGetFoodBasketUseCase(foodBasketRepository)
    }

    @Provides
    fun provideGetFoodBasketByIdUseCase(foodBasketRepository: FoodBasketRepository): GetFoodBasketByIdUseCase {
        return GetFoodBasketByIdUseCase(foodBasketRepository)
    }
}