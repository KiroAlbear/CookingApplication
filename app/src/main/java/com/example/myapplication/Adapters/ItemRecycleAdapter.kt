package com.example.myapplication.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FoodItemBinding
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.one_ingredient_layout.view.*


class ItemRecycleAdapter(var ingredientsList: List<String>) :
    RecyclerView.Adapter<ItemRecycleAdapter.Companion.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var view: View = LayoutInflater.from(p0.context).inflate(R.layout.one_ingredient_layout, p0, false)
        var myHolder = MyViewHolder(view)
        return myHolder
    }

    override fun getItemCount(): Int {
        return ingredientsList.count()
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.myTextView?.text = ingredientsList[p1]
    }


    companion object {
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            var myTextView: TextView? = null

            init {
                myTextView = itemView.findViewById(R.id.ingredientsLine)
            }

        }
    }
}