package ru.kiruxadance.feature_food_basket.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kiruxadance.feature_food_basket.domain.model.FoodBasket

class FoodBasketRecyclerAdapter(private val foodBasket: List<FoodBasket>): RecyclerView
.Adapter<FoodBasketRecyclerAdapter.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener
    private lateinit var onMinusItemClickListener: OnItemClickListener
    private lateinit var onPlusItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setOnMinusItemClickListener(onMinusItemClickListener: OnItemClickListener) {
        this.onMinusItemClickListener = onMinusItemClickListener
    }

    fun setOnPlusItemClickListener(onPlusItemClickListener: OnItemClickListener) {
        this.onPlusItemClickListener = onPlusItemClickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.item_title)
        val image = itemView.findViewById<ImageView>(R.id.item_image)
        val price = itemView.findViewById<TextView>(R.id.item_price)
        val weight = itemView.findViewById<TextView>(R.id.item_weight)
        val minus = itemView.findViewById<ImageView>(R.id.item_minus)
        val count = itemView.findViewById<TextView>(R.id.item_count)
        val plus = itemView.findViewById<ImageView>(R.id.item_plus)
        val item = itemView.findViewById<FrameLayout>(R.id.item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_basket_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return foodBasket.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = foodBasket[position].name
        holder.image.load(foodBasket[position].image_url)
        holder.price.text = "${foodBasket[position].price} ₽"
        holder.weight.text = "· ${foodBasket[position].weight}"
        holder.minus.setOnClickListener {
            onMinusItemClickListener.onItemClick(position)
        }
        holder.count.text = foodBasket[position].count.toString()
        holder.plus.setOnClickListener {
            onPlusItemClickListener.onItemClick(position)
        }
        holder.item.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}