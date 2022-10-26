package com.example.retrotifrxjavademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class MainViewModel : ViewModel() {
    val foods = MutableLiveData<List<Food>>()

    private val besinApiService= BesinAPIService()
    private val disposable = CompositeDisposable()


    fun refreshData(){
        getDataFromNet()

    }

    private fun getDataFromNet(){
    disposable.add(
        besinApiService.getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Food>>(){
                override fun onSuccess(t: List<Food>) {
                    foods.value = t
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    }

            })
    )
    }
}


