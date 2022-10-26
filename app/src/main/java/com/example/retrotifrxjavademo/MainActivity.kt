package com.example.retrotifrxjavademo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels

import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var viewmodel : MainViewModel
    private val rv_adapter = rvAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hold : MainViewModel by viewModels()
        this.viewmodel = hold
        hold.refreshData()


        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter  = rv_adapter

        observe()
    }

    private fun observe(){
        viewmodel.foods.observe(this) { foods ->
            foods?.let {
                rv_adapter.listOfUpdate(it)
            }
        }
    }


}


