package com.example.myapplication.Request


import com.example.myapplication.Response.RecipeItem
import com.example.myapplication.Response.RecipeItemResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface JsonApiHolder {

    @GET("/recipes/random?")
    fun getRandomDishes(
        @Query("apiKey")
        apiKey:String,
        @Query("tags")
        tags : String,
        @Query("number")
        number:Int,
        @Query("limitLicense")
        limitLicense: Boolean = false
    ): Observable<RecipeItemResponseModel>

    @GET("/recipes/findByIngredients?")
    fun getIngredients(
        @Query("apiKey")
        apiKey:String,
        @Query("ingredients")
        ingredients: String,
        @Query("number")
        number: Int = 100,
        @Query("limitLicense")
        limitLicense : Boolean = false,
        @Query("ranking")
        ranking: String = "",
        @Query("ignorePantry")
        ignorePantry: String = ""
    ): Observable<List<RecipeItem>>

    @GET("/recipes/{id}/information?")
    fun getOneRecipeInformation(
        @Path("id")
        id : String,
        @Query("apiKey")
        apiKey:String

    ): Observable<RecipeItem>

//
//    @GET("search?")
//    fun searchIngredients(
//        @Query("key") key: String
//        , @Query("q") ingredients: String
//    ):Observable<RecipeResponseModel>


}
