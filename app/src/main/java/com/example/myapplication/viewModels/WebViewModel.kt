package com.example.myapplication.viewModels

import android.util.Log
import com.example.myapplication.ApiCall.RetrofitCalling
import com.example.myapplication.GlobalResources.GlobalStrings
import com.example.myapplication.Navigators.WebViewNavigator
import com.example.myapplication.Request.JsonApiHolder
import com.example.myapplication.databinding.ActivityWebViewBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WebViewModel(webViewNavigator: WebViewNavigator) {
    val navigator = webViewNavigator

    fun getRecipeInfromation(id:String){

        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
        var observable: Disposable? = apiHolder.getOneRecipeInformation(id,GlobalStrings.APIKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ response ->
                if (response.toString().isNotEmpty())
                    Log.d("loadSampleDishes",response.toString())
                navigator.onRecipeInformation(response)

            },{
                    err -> Log.d("loadSampleDishes",err.toString())
              }
            )
    }
}