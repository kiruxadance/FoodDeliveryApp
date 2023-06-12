package ru.kiruxadance.feature_food_detail.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.database.data_providers.FoodBasketDataProviders
import ru.kiruxadance.feature_food_detail.data.repository.FoodBasketRepositoryImpl
import ru.kiruxadance.feature_food_detail.domain.repository.FoodBasketRepository

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {
    @Provides
    fun provideFoodBasketRepository(foodBasketDataProviders: FoodBasketDataProviders) : FoodBasketRepository {
        return FoodBasketRepositoryImpl(foodBasketDataProviders)
    }
}