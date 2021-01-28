package com.example.myapplication.Response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ReciptInformationRespopnseModel (
    @SerializedName("id")
    var id: Int ,
    @SerializedName("title")
    var title: String? ,
    @SerializedName("sourceUrl")
    var sourceUrl: String? ,
    @SerializedName("image")
    var image: String? ,
    @SerializedName("imageType")
    var imageType: String?

):Serializable

