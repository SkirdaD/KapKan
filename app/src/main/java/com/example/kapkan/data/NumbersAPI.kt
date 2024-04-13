package com.example.kapkan.data

import retrofit2.Call
import retrofit2.http.GET

interface NumbersAPI {
    @GET("KapKan/master/stringData")
    fun getAllNumbers(): Call<NumbersData>
}