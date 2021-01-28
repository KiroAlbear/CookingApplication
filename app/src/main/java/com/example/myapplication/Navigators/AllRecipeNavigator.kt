package com.example.myapplication.Navigators

import com.example.myapplication.Response.RecipeItem
import com.example.myapplication.Response.RecipeItemResponseModel


interface AllRecipeNavigator {
    fun onCalledApi(body : RecipeItemResponseModel)
    fun onSearchApi(body : List<RecipeItem>)
}