package com.example.kapkan.Data.Retrofit

import retrofit2.Call
import retrofit2.http.GET

interface NumbersAPI {
    @GET("KapKan/master/stringData")
    fun getAllNumbers(): Call<NumbersData>
}