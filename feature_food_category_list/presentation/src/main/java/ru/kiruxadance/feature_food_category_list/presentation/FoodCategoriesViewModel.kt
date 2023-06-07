package ru.kiruxadance.feature_food_category_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.kiruxadance.core.common.Resource
import ru.kiruxadance.feature_food_category_list.domain.model.FoodCategory
import ru.kiruxadance.feature_food_category_list.domain.use_cases.GetFoodCategoriesUseCase
import javax.inject.Inject

@HiltViewModel
class FoodCategoriesViewModel @Inject constructor(
    private val getFoodCategoriesUseCase: GetFoodCategoriesUseCase
): ViewModel() {

    private val _foodCategoryList: MutableStateFlow<FoodCategoriesStateHolder?> = MutableStateFlow(FoodCategoriesStateHolder())
    val foodCategoryList: StateFlow<FoodCategoriesStateHolder?> = _foodCategoryList.asStateFlow()

    init {
        viewModelScope.launch {
            getFoodCategories()
        }
    }

    private fun getFoodCategories() = viewModelScope.launch {
        getFoodCategoriesUseCase().onEach {
            when(it) {
                is Resource.Error -> {
                    _foodCategoryList.value = FoodCategoriesStateHolder(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _foodCategoryList.value = FoodCategoriesStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    _foodCategoryList.value = FoodCategoriesStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}