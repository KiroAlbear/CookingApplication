package com.example.myapplication.Adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.IngredientsViewModel
import com.example.myapplication.databinding.OneIngredientLayoutBinding
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import com.example.myapplication.R


class ItemRecycleAdapter(var ingredientsList: List<String>, var context: Context) :
    RecyclerView.Adapter<ItemRecycleAdapter.Companion.MyViewHolder>() {

    private var ingCounter: Int = 1
    private var Colors = intArrayOf(
        Color.rgb(76, 224, 62),
        Color.rgb(118, 128, 242),
        Color.rgb(33, 136, 255),
        Color.rgb(222, 249, 49),
        Color.rgb(255, 33, 33),
        Color.rgb(227, 255, 71),
        Color.rgb(247, 61, 24),
        Color.rgb(62, 224, 205),
        Color.rgb(107, 62, 224),
        Color.rgb(170, 62, 224),
        Color.rgb(224, 62, 175)
    )


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var itemBinding: OneIngredientLayoutBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(p0.context),
                com.example.myapplication.R.layout.one_ingredient_layout,
                p0,
                false
            )

        var myHolder = MyViewHolder(itemBinding.root, itemBinding)
        return myHolder
    }

    override fun getItemCount(): Int {
        return ingredientsList.count()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {


        if(ingCounter%2==0){
            p0.ingredientLayoutBinding.ingLayout.setBackgroundColor(context.getColor(R.color.white))
        }

        var ingVm = IngredientsViewModel(ingredientsList[p1], ingCounter.toString())
        ingCounter++

        p0.ingredientLayoutBinding.ingVM = ingVm


    }


    companion object {
        class MyViewHolder(itemView: View, oneIngredientLayoutBinding: OneIngredientLayoutBinding) :
            RecyclerView.ViewHolder(itemView) {

            var ingredientLayoutBinding: OneIngredientLayoutBinding = oneIngredientLayoutBinding


        }
    }
}