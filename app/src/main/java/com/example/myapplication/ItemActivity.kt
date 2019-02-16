package com.example.myapplication

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.myapplication.Adapters.FoodRecycleAdapter
import com.example.myapplication.Adapters.ItemRecycleAdapter
import com.example.myapplication.ApiCall.ApiHelper
import com.example.myapplication.ApiCall.CallStrings
import com.example.myapplication.ApiCall.RetrofitCalling
import com.example.myapplication.ApiCall.ingredientApi
import com.example.myapplication.Request.JsonApiHolder
import com.example.myapplication.Response.ItemBody
import com.example.myapplication.Response.RecipeBody
import com.example.myapplication.Response.RecipeResponseModel
import com.example.myapplication.databinding.ActivityItemBinding

import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ItemActivity : AppCompatActivity(), ingredientApi {
    lateinit var bundle: Bundle
    lateinit var recipeId: String
    lateinit var databinding: ActivityItemBinding
    lateinit var itemRecycle: ItemRecycleAdapter


    override fun onGetIngredients(body: ItemBody) {
        var itemModel = ItemViewModel(
            body.recipes.publisher,
            body.recipes.f2f_url,
            body.recipes.ingredients,
            body.recipes.source_url,
            body.recipes.recipe_id,
            body.recipes.image_url,
            body.recipes.social_rank,
            body.recipes.publisher_url,
            body.recipes.title
        )

        itemModel.loadimage(databinding.itemDishImage.dishImage)
        databinding.itemVM = itemModel
        itemRecycle = ItemRecycleAdapter(body.recipes.ingredients)
        databinding.itemIngredients.adapter=itemRecycle


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        bundle = intent.extras

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_item)
        databinding.itemIngredients.layoutManager=LinearLayoutManager(this)
        databinding.itemIngredients.setHasFixedSize(true)
        recipeId = bundle.get("rid") as String
        getIngredients()

    }

    fun getIngredients() {
        var apiHolder: JsonApiHolder = RetrofitCalling.getApiHolder()
        var observable: Disposable? = apiHolder.getIngredients(CallStrings.APIKEY, recipeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                onGetIngredients(response)

            }


    }
}
