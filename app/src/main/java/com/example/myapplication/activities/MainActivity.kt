package com.example.myapplication.activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.example.myapplication.Adapters.FoodRecycleAdapter
import com.example.myapplication.ApiCall.ApiHelper

import com.example.myapplication.Response.RecipeResponseModel

import com.example.myapplication.databinding.ActivityMainBinding
import android.support.v7.widget.GridLayoutManager
import com.mancj.materialsearchbar.MaterialSearchBar
import android.app.Activity
import android.view.inputmethod.InputMethodManager
import com.example.myapplication.R
import com.example.myapplication.viewModel.MyViewModel


class MainActivity : AppCompatActivity(), ApiHelper, MaterialSearchBar.OnSearchActionListener {
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
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    lateinit var databinding: ActivityMainBinding
    lateinit var recycleAdapter: FoodRecycleAdapter
    lateinit var viewmodel: MyViewModel
    override fun onCalledApi(body: RecipeResponseModel) {


        recycleAdapter = FoodRecycleAdapter(body)
        databinding.foodRecycleView.adapter = recycleAdapter

    }

    override fun onSearchApi(body: RecipeResponseModel) {
        recycleAdapter = FoodRecycleAdapter(body)
        databinding.foodRecycleView.adapter = recycleAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.foodRecycleView.layoutManager = LinearLayoutManager(this)
        databinding.foodRecycleView.setHasFixedSize(true)
        databinding.foodRecycleView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)


        viewmodel = MyViewModel(this)
        viewmodel.loadSampleDishes(this)

        databinding.searchView.setOnSearchActionListener(this)


    }


}

