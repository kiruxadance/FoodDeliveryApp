package ru.kiruxadance.feature_food_basket.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.database.data_providers.FoodBasketDataProviders
import ru.kiruxadance.feature_food_basket.data.repository.FoodBasketRepositoryImpl
import ru.kiruxadance.feature_food_basket.domain.repository.FoodBasketRepository

@Module
@InstallIn(SingletonComponent::class)
class DataLayerModule {
    @Provides
    fun provideFoodBasketRepository(foodBasketDataProviders: FoodBasketDataProviders): FoodBasketRepository {
        return FoodBasketRepositoryImpl(foodBasketDataProviders)
    }
}