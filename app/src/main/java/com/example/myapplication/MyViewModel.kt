package com.example.myapplication

import android.content.Context
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.myapplication.Adapters.FoodRecycleAdapter
import com.squareup.picasso.Picasso
import java.io.Serializable
import java.util.*

class MyViewModel(
    var publisher: String,
    var f2f_url: String,
    var title: String,
    var source_url: String,
    var recipe_id: String,
    var image_url: String,
    var social_rank: String,
    var publisher_url: String
) : Serializable