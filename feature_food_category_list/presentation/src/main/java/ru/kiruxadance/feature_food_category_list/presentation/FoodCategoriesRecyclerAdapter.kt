package ru.kiruxadance.feature_food_category_list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kiruxadance.feature_food_category_list.domain.model.FoodCategory

class FoodCategoriesRecyclerAdapter(private val foodCategories: List<FoodCategory>) : RecyclerView
    .Adapter<FoodCategoriesRecyclerAdapter.ViewHolder>()
{
    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text_categories)
        val imageView = itemView.findViewById<ImageView>(R.id.image_categories)

        init {
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return foodCategories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = foodCategories[position].name
        holder.imageView.load(foodCategories[position].image_url) {

        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}