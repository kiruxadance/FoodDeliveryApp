package ru.kiruxadance.feature_food_detail.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket
import ru.kiruxadance.feature_food_detail.domain.repository.FoodBasketRepository
import javax.inject.Inject

class GetFoodBasketByIdUseCase @Inject constructor(
    private val foodBasketRepository: FoodBasketRepository
){
    suspend operator fun invoke(id: Int) = flow {
        emit(Resource.Loading())
        emit(Resource.Success(foodBasketRepository.getFoodBasketById(id)))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}