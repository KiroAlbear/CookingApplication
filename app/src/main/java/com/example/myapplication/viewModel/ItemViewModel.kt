package com.example.myapplication.viewModel

import android.webkit.WebView
import android.widget.ImageView
import com.example.myapplication.ApiCall.ApiHelper
import com.example.myapplication.ApiCall.webViewInterface
import com.example.myapplication.R
import com.example.myapplication.activities.MainActivity
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

   lateinit var webViewInterface: webViewInterface
    fun loadimage(imageView:ImageView){

        Picasso.get()
            .load(image_url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }

    fun onDescriptionButtonClick(){
       webViewInterface.onDescriptionButtoneClick(publisher_url)
    }
}




