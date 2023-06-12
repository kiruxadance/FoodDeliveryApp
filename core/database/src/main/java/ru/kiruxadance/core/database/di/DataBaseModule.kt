package ru.kiruxadance.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.database.FoodBasketDatabase
import ru.kiruxadance.core.database.data_providers.FoodBasketDataProviders
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideFoodBasketDatabase(@ApplicationContext context: Context): FoodBasketDatabase {
        return Room.databaseBuilder(
            context,
            FoodBasketDatabase::class.java,
            "foodBasket.db"
        ).build()
    }

    @Provides
    fun provideFoodBasketDataProvider(db: FoodBasketDatabase) : FoodBasketDataProviders {
        return FoodBasketDataProviders(db)
    }
}