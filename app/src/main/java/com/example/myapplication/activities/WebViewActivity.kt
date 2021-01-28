package com.example.myapplication.activities

import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.myapplication.GlobalResources.GlobalStrings
import com.example.myapplication.Navigators.WebViewNavigator
import com.example.myapplication.R
import com.example.myapplication.Response.RecipeItem
import com.example.myapplication.databinding.ActivityWebViewBinding
import com.example.myapplication.viewModels.WebViewModel

class WebViewActivity : AppCompatActivity(),WebViewNavigator {
    lateinit var webViewModel: WebViewModel
    lateinit var dataBinding: ActivityWebViewBinding


    override fun onRecipeInformation(recipe: RecipeItem) {
        dataBinding.descriptionWebview.loadUrl(recipe.sourceUrl)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webViewModel = WebViewModel(this)

        val recipeUrl:String? = intent.extras!!.getString(GlobalStrings.RECIPE_ITEM_URL_KEY)
        val recipeID:String? = intent.extras!!.getString(GlobalStrings.RECIPE_ITEM_ID_KEY)


        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_web_view)



        if (recipeUrl == null)
            webViewModel.getRecipeInfromation(recipeID!!)

        else
            dataBinding.descriptionWebview.loadUrl(recipeUrl)


        dataBinding.descriptionWebview.webViewClient = object : WebViewClient() {
             override fun onPageFinished(view: WebView?, url: String?) {
                 super.onPageFinished(view, url)
                 dataBinding.newsProgBar.visibility = View.GONE
             }

             override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                 super.onPageStarted(view, url, favicon)
                 dataBinding.newsProgBar.visibility = View.VISIBLE
             }
         }





    }

    fun loadURL(url:String){

    }
}
