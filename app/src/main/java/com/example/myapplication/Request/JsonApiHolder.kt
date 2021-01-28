package com.example.myapplication.Request


import com.example.myapplication.Response.RecipeItemResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface JsonApiHolder {

    @GET("/recipes/random?")
    fun getSampleDishes(
        @Query("apiKey")
        apiKey:String,
        @Query("limitLicense")
        limitLicense: Boolean,
        @Query("tags")
        tags : String,
        @Query("number")
        number:Int =1
    ): Observable<RecipeItemResponseModel>

//    @GET("get?")
//    fun getIngredients(
//        @Query("key") key: String,
//        @Query("rId") id: String
//    ): Observable<ItemBody>
//
//    @GET("search?")
//    fun searchIngredients(
//        @Query("key") key: String
//        , @Query("q") ingredients: String
//    ):Observable<RecipeResponseModel>


}
