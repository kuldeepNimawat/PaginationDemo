package com.kuldeep.paginationdemo.network

import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("character")
    suspend fun getDataFromApi(@Query("page") query: Int) : RickAndMortyList
}