package com.example.myapplication

import android.app.Application
import android.content.Context
import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.myapplication.Adapters.FoodRecycleAdapter
import com.example.myapplication.ApiCall.ApiHelper
import com.example.myapplication.ApiCall.CallStrings
import com.example.myapplication.ApiCall.RetrofitCalling
import com.example.myapplication.Request.JsonApiHolder
import com.example.myapplication.Response.RecipeBody
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.Serializable
import java.util.*

class MyViewModel(

) : Serializable {
    lateinit var publisher: String
    lateinit var f2f_url: String
    lateinit var title: String
    lateinit var source_url: String
    lateinit var recipe_id: String
    lateinit var image_url: String
    lateinit var social_rank: String
    lateinit var publisher_url: String
    lateinit var apiHelperInterface: ApiHelper


    constructor(
        publisher: String,
        f2f_url: String,
        title: String,
        source_url: String,
        recipe_id: String,
        image_url: String,
        social_rank: String,
        publisher_url: String
    ) : this() {
        this.publisher = publisher
        this.f2f_url = f2f_url
        this.title = title
        this.source_url = source_url
        this.recipe_id = recipe_id
        this.image_url = image_url
        this.social_rank = social_rank
        this.publisher_url = publisher_url
    }

    constructor(apiHelperInterface: ApiHelper) : this() {
        this.apiHelperInterface = apiHelperInterface
    }

    fun loadSampleDishes(context: Context) {
        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
        var observable: Disposable? = apiHolder.getSampleDishes(CallStrings.APIKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->

                if (response.toString().isNotEmpty())
                    apiHelperInterface.onCalledApi(response)
                else
                    RetrofitCalling.noApiResponse(context)

            }
    }

    fun loadSearchDishes(ingredients: String) {

        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()

        var observable: Disposable? = apiHolder.searchIngredients(CallStrings.APIKEY, ingredients)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                if (response.toString().isNotEmpty())
                    apiHelperInterface.onSearchApi(response)

            }
    }


}