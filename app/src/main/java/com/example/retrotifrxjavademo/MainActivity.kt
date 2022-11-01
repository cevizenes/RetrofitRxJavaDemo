package com.example.retrotifrxjavademo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrotifrxjavademo.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var viewmodel : MainViewModel
    private val rv_adapter = rvAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hold : MainViewModel by viewModels()
        this.viewmodel = hold
        hold.refreshData()

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rv.adapter = rv_adapter
        observe()



    }

    private fun observe(){
        viewmodel.foods.observe(this@MainActivity) { foods ->
            foods?.let {
                rv_adapter.listOfUpdate(it)

            }


    }






}
}

