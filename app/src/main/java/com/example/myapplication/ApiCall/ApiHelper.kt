package com.example.myapplication.ApiCall

import com.example.myapplication.Response.RecipeItemResponseModel


interface ApiHelper {
    fun onCalledApi(body : RecipeItemResponseModel)
//    fun onSearchApi(body : RecipeResponseModel)
}