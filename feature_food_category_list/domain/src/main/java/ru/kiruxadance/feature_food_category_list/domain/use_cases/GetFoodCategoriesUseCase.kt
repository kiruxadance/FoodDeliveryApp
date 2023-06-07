package ru.kiruxadance.feature_food_category_list.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_category_list.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodCategoriesUseCase @Inject constructor(
    private val foodRepository: FoodRepository
){
    operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(Resource.Success(foodRepository.getFoodCategories()))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}