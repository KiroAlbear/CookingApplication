package com.example.myapplication.viewModel

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.example.myapplication.ApiCall.ApiHelper
import com.example.myapplication.ApiCall.CallStrings
import com.example.myapplication.ApiCall.RetrofitCalling
import com.example.myapplication.R
import com.example.myapplication.Request.JsonApiHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.Serializable
import kotlin.math.log

class MyViewModel(

) : Serializable {


    private lateinit var apiHelperInterface: ApiHelper
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

    constructor(apiHelperInterface: ApiHelper) : this() {
        this.apiHelperInterface = apiHelperInterface
    }

    fun loadSampleDishes(context: Context) {
        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
        var observable: Disposable? = apiHolder.getSampleDishes(CallStrings.APIKEY,true,"vegetarian,dessert",10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({response ->

                    if (response.toString().isNotEmpty())
                        apiHelperInterface.onCalledApi(response)
                    else
                        RetrofitCalling.noApiResponse(context)
            },{
                    er -> Log.d("loadSampleDishes",er.toString())

              }


            )
    }

//    fun loadSearchDishes(ingredients: String) {
//
//        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
//
//        var observable: Disposable? = apiHolder.searchIngredients(CallStrings.APIKEY, ingredients)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { response ->
//                if (response.toString().isNotEmpty())
//                    apiHelperInterface.onSearchApi(response)
//
//            }
//    }


}