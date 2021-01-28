package com.example.myapplication.ApiCall

import android.content.Context
import android.widget.Toast
import com.example.myapplication.GlobalResources.GlobalStrings
import com.example.myapplication.Request.JsonApiHolder

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCalling{


    companion object {
        fun getRetrofitInstance():Retrofit{

            var ret:Retrofit= Retrofit.Builder()
                .baseUrl(GlobalStrings.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return ret
        }

        fun getApiHolder(): JsonApiHolder {
            return getRetrofitInstance().create(JsonApiHolder::class.java)
        }

        fun noApiResponse(context: Context){
            Toast.makeText(context,"Api Has Expired",Toast.LENGTH_SHORT).show()
        }

    }


}