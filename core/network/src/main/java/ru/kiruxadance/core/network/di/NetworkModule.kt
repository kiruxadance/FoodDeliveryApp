package ru.kiruxadance.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kiruxadance.core.network.ApiService
import ru.kiruxadance.core.network.data_providers.FoodDataProviders

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BaseUrlFoodApi = "https://run.mocky.io/"

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(BaseUrlFoodApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideFoodDataProvider(apiService: ApiService) : FoodDataProviders {
        return FoodDataProviders(apiService)
    }
}