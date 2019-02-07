package com.example.myapplication.Adapters

import android.view.View
import com.example.myapplication.Response.RecipeBody

interface ViewHolderInterface {
    fun onClick(view: View, data: RecipeBody)
}