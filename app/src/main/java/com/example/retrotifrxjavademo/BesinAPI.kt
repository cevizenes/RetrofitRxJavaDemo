package com.example.retrotifrxjavademo

import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {

    // // URL https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getData(): Single<List<Food>>
}