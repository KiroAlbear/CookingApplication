package com.example.myapplication

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ItemViewModel(
    var publisher: String,
    var f2f_url: String,
    var ingredients: ArrayList<String>,
    var source_url: String,
    var recipe_id: String,
    var image_url: String,
    var social_rank: String,
    var publisher_url: String,
    var title: String
)
{
    fun loadimage(imageView:ImageView){

        Picasso.get()
            .load(image_url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }
}




