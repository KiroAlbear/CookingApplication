package com.example.myapplication.ApiCall

import com.example.myapplication.Response.ItemBody
import com.example.myapplication.Response.RecipeResponseModel


interface ApiHelper {
    fun onCalledApi(body : RecipeResponseModel)
    fun onSearchApi(body : RecipeResponseModel)
}