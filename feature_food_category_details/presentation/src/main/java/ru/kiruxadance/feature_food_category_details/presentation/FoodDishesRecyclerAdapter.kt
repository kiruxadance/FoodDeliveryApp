package ru.kiruxadance.feature_food_category_details.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kiruxadance.feature_food_category_details.domain.model.FoodDishes

class FoodDishesRecyclerAdapter(private val foodDishes: List<FoodDishes>) : RecyclerView.Adapter<FoodDishesRecyclerAdapter.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.item_text)
        val imageView = itemView.findViewById<ImageView>(R.id.item_image)

        init {
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return foodDishes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = foodDishes[position].name
        if (foodDishes[position].image_url != null) {
            holder.imageView.load(foodDishes[position].image_url)
        } else {
            holder.imageView.load(R.drawable.no_image)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}