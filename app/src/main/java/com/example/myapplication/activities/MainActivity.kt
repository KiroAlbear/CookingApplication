package com.example.myapplication.activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.example.myapplication.Navigators.AllRecipeNavigator


import com.example.myapplication.databinding.ActivityMainBinding
import android.support.v7.widget.GridLayoutManager
import com.mancj.materialsearchbar.MaterialSearchBar
import android.app.Activity
import android.support.v4.widget.SwipeRefreshLayout
import android.view.inputmethod.InputMethodManager
import com.example.myapplication.Adapters.AllRecipeRecycleAdapter
import com.example.myapplication.R
import com.example.myapplication.Response.RecipeItem
import com.example.myapplication.Response.RecipeItemResponseModel
import com.example.myapplication.viewModels.MyViewModel


class MainActivity : AppCompatActivity(), AllRecipeNavigator, MaterialSearchBar.OnSearchActionListener {

    override fun onButtonClicked(buttonCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSearchStateChanged(enabled: Boolean) {
        return
    }

    override fun onSearchConfirmed(text: CharSequence?) {
        viewmodel.loadSearchDishes(text.toString())

        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = this.currentFocus

        // close keyboard
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    lateinit var databinding: ActivityMainBinding
    lateinit var recycleAdapter: AllRecipeRecycleAdapter
    lateinit var viewmodel: MyViewModel
    override fun onCalledApi(body: RecipeItemResponseModel) {

        recycleAdapter = AllRecipeRecycleAdapter(body)
        databinding.recipesRecycleView.adapter = recycleAdapter
        databinding.swipeRefreshLayout.isRefreshing = false

    }

    override fun onSearchApi(body: List<RecipeItem>) {

        recycleAdapter = AllRecipeRecycleAdapter(RecipeItemResponseModel(body))
        databinding.recipesRecycleView.adapter = recycleAdapter
        recycleAdapter.notifyDataSetChanged()


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.recipesRecycleView.layoutManager = LinearLayoutManager(this)
        databinding.recipesRecycleView.setHasFixedSize(true)
        databinding.recipesRecycleView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)


        viewmodel = MyViewModel(this)
        viewmodel.loadSampleDishes(this)

        databinding.searchView.setOnSearchActionListener(this)



        databinding.swipeRefreshLayout.setOnRefreshListener {

                viewmodel.loadSampleDishes(applicationContext)



         }



    }


}

