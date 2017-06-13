package com.thebooker.thebooker.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    val theBookerApi: TheBookerAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://thebookerapi.azurewebsites.net/api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()


        theBookerApi = retrofit.create(TheBookerAPI::class.java)
    }
}