package ru.kiruxadance.feature_food_category_details.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.network.data_providers.FoodDataProviders
import ru.kiruxadance.feature_food_category_details.data.repository.FoodRepositoryImpl
import ru.kiruxadance.feature_food_category_details.domain.repository.FoodRepository

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {

    @Provides
    fun provideFoodRepository(foodDataProviders: FoodDataProviders): FoodRepository {
        return FoodRepositoryImpl(foodDataProviders)
    }
}