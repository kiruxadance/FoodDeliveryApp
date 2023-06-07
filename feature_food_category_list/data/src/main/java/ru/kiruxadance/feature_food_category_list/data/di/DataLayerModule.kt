package ru.kiruxadance.feature_food_category_list.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.network.data_providers.FoodDataProviders
import ru.kiruxadance.feature_food_category_list.data.repository.FoodRepositoryImpl
import ru.kiruxadance.feature_food_category_list.domain.repository.FoodRepository

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {

    @Provides
    fun provideFoodRepository(foodDataProviders: FoodDataProviders) : FoodRepository {
        return FoodRepositoryImpl(foodDataProviders)
    }
}