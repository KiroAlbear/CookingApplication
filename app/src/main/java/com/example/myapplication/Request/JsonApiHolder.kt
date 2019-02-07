package com.example.myapplication.Request


import com.example.myapplication.Response.ItemBody
import com.example.myapplication.Response.RecipeResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface JsonApiHolder {

    @GET("search?")
    fun getSampleDishes(
        @Query("key")
        key: String
    ): Observable<RecipeResponseModel>

    @GET("get?")
    fun getIngredients(
        @Query("key") key: String,
        @Query("rId") id: String
    ): Observable<ItemBody>

    @GET("search?")
    fun searchIngredients(
        @Query("key") key: String
        , @Query("q") ingredients: String
    )


}
