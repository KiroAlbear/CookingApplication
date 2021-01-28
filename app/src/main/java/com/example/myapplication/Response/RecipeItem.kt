package com.example.myapplication.Response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RecipeItemResponseModel(
    var recipes:List<RecipeItem>
    ):Serializable

class RecipeItem (
    @SerializedName("id")
    var id: String ,
    @SerializedName("title")
    var title: String? ,
    @SerializedName("sourceUrl")
    var sourceUrl: String? ,
    @SerializedName("image")
    var image: String? ,
    @SerializedName("imageType")
    var imageType: String?

):Serializable

