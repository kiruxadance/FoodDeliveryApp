package ru.kiruxadance.feature_food_basket.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_basket.domain.repository.FoodBasketRepository
import javax.inject.Inject

class GetAllFoodBasketUseCase @Inject constructor(
    private val foodBasketRepository: FoodBasketRepository
){
    suspend operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(Resource.Success(foodBasketRepository.getAllFoodBasket()))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}