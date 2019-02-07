package com.example.myapplication.ApiCall

import com.example.myapplication.Request.JsonApiHolder
import com.example.myapplication.Response.RecipeBody

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCalling{

    private lateinit var ret:Retrofit
    private lateinit var apiHolder: JsonApiHolder
    private lateinit var call:Call<List<RecipeBody>>

    companion object {
        fun getRetrofitInstance():Retrofit{

            var ret:Retrofit= Retrofit.Builder()
                .baseUrl(CallStrings.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return ret
        }

        fun getApiHolder(): JsonApiHolder {
            return getRetrofitInstance().create(JsonApiHolder::class.java)
        }
    }


}