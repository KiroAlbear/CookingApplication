package com.example.myapplication.viewModels

import android.content.Context
import android.util.Log
import com.example.myapplication.Navigators.AllRecipeNavigator
import com.example.myapplication.GlobalResources.GlobalStrings
import com.example.myapplication.ApiCall.RetrofitCalling
import com.example.myapplication.Request.JsonApiHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.Serializable

class MyViewModel(

) : Serializable {


    lateinit var navigator: AllRecipeNavigator
    var recipe_id: String? = null
    var title: String? = null
    var image_url: String? = null
    var source_url: String? = null

    constructor(
        title: String?,
        source_url: String?,
        recipe_id: String?,
        image_url: String?
    ) : this() {

        this.title = title
        this.source_url = source_url
        this.recipe_id = recipe_id
        this.image_url = image_url
    }

    constructor(allRecipeNavigatorInterface: AllRecipeNavigator) : this() {
        this.navigator = allRecipeNavigatorInterface
    }

    fun loadSampleDishes(context: Context) {
        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
        var observable: Disposable? = apiHolder.getRandomDishes(GlobalStrings.APIKEY,"",100)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({response ->

                    if (response.toString().isNotEmpty())
                        navigator.onCalledApi(response)
                    else
                        RetrofitCalling.noApiResponse(context)
            },{
                    err -> Log.d("loadSampleDishes",err.toString())

              }


            )
    }

    fun loadSearchDishes(ingredients: String) {

        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()

        var observable: Disposable? = apiHolder.getIngredients(GlobalStrings.APIKEY,ingredients)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ response ->
                if (response.toString().isNotEmpty())
                    Log.d("loadSampleDishes",response.toString())
                    navigator.onSearchApi(response)

            },{
                err -> Log.d("loadSampleDishes",err.toString())
              }
            )
    }


}