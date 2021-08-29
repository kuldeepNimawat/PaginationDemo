package com.kuldeep.paginationdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        fun getRetroInstance(): Retrofit{
            val baseUrl="https://rickandmortyapi.com/api/"
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}