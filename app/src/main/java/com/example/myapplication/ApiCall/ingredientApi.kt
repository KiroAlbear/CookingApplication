package com.example.myapplication.ApiCall

import com.example.myapplication.Response.ItemBody

interface ingredientApi {
    fun onGetIngredients(body: ItemBody)
}