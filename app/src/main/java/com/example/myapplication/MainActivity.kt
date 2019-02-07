package com.example.myapplication

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.example.myapplication.Adapters.FoodRecycleAdapter
import com.example.myapplication.ApiCall.ApiHelper
import com.example.myapplication.ApiCall.CallStrings
import com.example.myapplication.ApiCall.RetrofitCalling

import com.example.myapplication.Request.JsonApiHolder
import com.example.myapplication.Response.RecipeResponseModel

import com.example.myapplication.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import android.support.v7.widget.GridLayoutManager


class MainActivity : AppCompatActivity(), ApiHelper {


    lateinit var databinding: ActivityMainBinding
    lateinit var recycleAdapter:FoodRecycleAdapter
    override fun onCalledApi(body: RecipeResponseModel) {


        recycleAdapter=FoodRecycleAdapter(body)
        databinding.foodRecycleView.adapter=recycleAdapter

    }

    override fun onSearchApi(body: RecipeResponseModel) {
        recycleAdapter=FoodRecycleAdapter(body)
        databinding.foodRecycleView.adapter=recycleAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.foodRecycleView.layoutManager = LinearLayoutManager(this)
        databinding.foodRecycleView.setHasFixedSize(true)
        databinding.foodRecycleView.layoutManager = GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false)


        loadJson()



    }

    fun loadJson() {
        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
        var observable: Disposable? = apiHolder.getSampleDishes(CallStrings.APIKEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                onCalledApi(response)

            }


    }

}
