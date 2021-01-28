package com.example.myapplication.Adapters

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import com.example.myapplication.viewModels.MyViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FoodItemBinding
import android.view.*
import com.example.myapplication.GlobalResources.GlobalStrings
import com.example.myapplication.Response.RecipeItemResponseModel
import com.example.myapplication.activities.WebViewActivity


import com.squareup.picasso.Picasso


class AllRecipeRecycleAdapter(recipeResponseModel: RecipeItemResponseModel) :
    RecyclerView.Adapter<AllRecipeRecycleAdapter.Companion.MyViewHolder>() {

    val foods: RecipeItemResponseModel = recipeResponseModel

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var itemBinding: FoodItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            com.example.myapplication.R.layout.food_item,
            p0,
            false
        )
//
//        var foodImageBinding: FoodImageBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(p0.context),
//            com.example.myapplication.R.layout.food_image,
//            p0,
//            false
//        )


        var myHolder = MyViewHolder(itemBinding.root, itemBinding)
        val height = p0.measuredHeight / 3
        myHolder.itemView.layoutParams.height = height
        return myHolder
    }

    override fun getItemCount(): Int {
        return foods.recipes.count()
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {



        var foodrecipe = MyViewModel(foods.recipes[p1].title,
            foods.recipes[p1].sourceUrl,
            foods.recipes[p1].id,foods.recipes[p1].title)

        p0.foodLayoutBinding.foodVm = foodrecipe


        p0.foodLayoutBinding.imageLayout.dishImage.setOnClickListener {


//            listener.onClick(it, foods.recipes[p1])
            var intent = Intent(it.context, WebViewActivity::class.java)
            intent.putExtra(GlobalStrings.RECIPE_ITEM_ID_KEY, foods.recipes[p1].id)
            intent.putExtra(GlobalStrings.RECIPE_ITEM_URL_KEY, foods.recipes[p1].sourceUrl)
            it.context.startActivity(intent)

        }

        Picasso.get()
            .load(foods.recipes[p1].image)
            .placeholder(R.mipmap.ginger)
            .into(p0.foodLayoutBinding.imageLayout.dishImage)

    }




    companion object {
        class MyViewHolder(itemView: View, foodLayoutBinding: FoodItemBinding) :
            RecyclerView.ViewHolder(itemView) {

            var foodLayoutBinding: FoodItemBinding = foodLayoutBinding


        }
    }
}

