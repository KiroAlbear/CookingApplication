package com.example.myapplication.Adapters

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.adapters.CardViewBindingAdapter
import android.os.Bundle
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import com.example.myapplication.MyViewModel
import com.example.myapplication.R
import com.example.myapplication.Response.RecipeBody
import com.example.myapplication.Response.RecipeResponseModel
import com.example.myapplication.databinding.FoodItemBinding
import android.util.DisplayMetrics
import android.view.*
import android.widget.AdapterView
import com.example.myapplication.ItemActivity


import com.squareup.picasso.Picasso


class FoodRecycleAdapter(recipeResponseModel: RecipeResponseModel) :
    RecyclerView.Adapter<FoodRecycleAdapter.Companion.MyViewHolder>() {

    val foods: RecipeResponseModel = recipeResponseModel

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var itemBinding: FoodItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            com.example.myapplication.R.layout.food_item,
            p0,
            false
        )
        var myHolder = MyViewHolder(itemBinding.root, itemBinding)
        val height = p0.measuredHeight / 2
        myHolder.itemView.layoutParams.height = height
        return myHolder
    }

    override fun getItemCount(): Int {
        return foods.count.toInt()
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        var foodrecipe = MyViewModel(
            foods.recipes[p1].publisher,
            foods.recipes[p1].f2f_url,
            foods.recipes[p1].title,
            foods.recipes[p1].source_url,
            foods.recipes[p1].recipe_id,
            foods.recipes[p1].image_url,
            foods.recipes[p1].social_rank,
            foods.recipes[p1].publisher_url
        )

        p0.foodLayoutBinding.foodVm = foodrecipe


        p0.foodLayoutBinding.dishImage.setOnClickListener {


           // listener.onClick(it, foods.recipes[p1])
            var intent = Intent(it.context,ItemActivity::class.java)
            intent.putExtra("rid",foods.recipes[p1].recipe_id)
            it.context.startActivity(intent)

        }

             Picasso.get()
            .load(foods.recipes[p1].image_url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(p0.foodLayoutBinding.dishImage)


    }



    companion object {
        class MyViewHolder(itemView: View, foodLayoutBinding: FoodItemBinding) : RecyclerView.ViewHolder(itemView) {

            var foodLayoutBinding: FoodItemBinding = foodLayoutBinding

        }
    }
}

