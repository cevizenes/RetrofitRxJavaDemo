package com.example.retrotifrxjavademo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("isim")
    var name : String?,
    @SerializedName("kalori")
    var calori: String?,
    @SerializedName("karbonhidrat")
    var carbonhidrat: String?,
    @SerializedName("protein")
    var protein : String?,
    @SerializedName("yag")
    var oil : String?,
    @SerializedName("gorsel")
    var image : String?

)