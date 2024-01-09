package com.example.kapkan.Data.Retrofit

import com.example.kapkan.Data.Retrofit.NumbersData
import retrofit2.Call
import retrofit2.http.GET

interface NumbersAPI {
    @GET("blob/master/stringData")
    fun getAllNumbers(): Call<NumbersData>
}