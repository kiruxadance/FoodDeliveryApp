package ru.kiruxadance.feature_food_detail.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.kiruxadance.feature_food_detail.domain.model.FoodBasket
import ru.kiruxadance.feature_food_detail.domain.model.FoodDetail
import ru.kiruxadance.feature_food_detail.presentation.databinding.FragmentDialogFoodDetailBinding
import ru.kiruxadance.feature_food_detail.presentation.mapper.toFoodBasket

@AndroidEntryPoint
class FoodDetailDialogFragment : DialogFragment() {

    private val viewModel by viewModels<FoodDetailViewModel>()
    private lateinit var data: FoodDetail

    private var _binding: FragmentDialogFoodDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var currentFoodBasket: FoodBasket

    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog)
            .setView(R.layout.fragment_dialog_food_detail)
            .create()
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDialogFoodDetailBinding.inflate(inflater, container, false)
        getDialog()?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gson = Gson()
        data = gson.fromJson(this.arguments?.getString("food"), FoodDetail::class.java)

        viewModel.getFoodBasketById(data.id)

        binding.dialogName.text = data.name
        binding.dialogPrice.text = "${data.price} ₽"
        binding.dialogWeight.text = "· ${data.weight}"
        binding.dialogDescription.text = data.description
        binding.dialogImage.load(data.image_url)

        binding.buttonAddToBasket.setOnClickListener {
            viewModel.insertAndGetFoodBasket(data.toFoodBasket(1))
        }

        binding.dialogMinus.setOnClickListener {
            currentFoodBasket.count = currentFoodBasket.count - 1
            viewModel.updateAndGetFoodBasket(currentFoodBasket)
        }

        binding.dialogPlus.setOnClickListener {
            currentFoodBasket.count = currentFoodBasket.count + 1
            viewModel.updateAndGetFoodBasket(currentFoodBasket)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.foodBasket.collectLatest {
                it?.let {
                    if (it.isLoading) {

                    }
                    if (it.error.isNotBlank()) {
                        showAddToBasket()
                    }
                    if (it.data != null) {
                        showCountBasket()
                        currentFoodBasket = it.data
                        binding.textBasketCount.text = it.data.count.toString()
                    } else {
                        showAddToBasket()
                    }
                }
            }
        }
    }

    private fun showAddToBasket() {
        binding.countBasket.visibility = View.GONE
        binding.buttonAddToBasket.visibility = View.VISIBLE
    }

    private fun showCountBasket() {
        binding.countBasket.visibility = View.VISIBLE
        binding.buttonAddToBasket.visibility = View.GONE
    }
}