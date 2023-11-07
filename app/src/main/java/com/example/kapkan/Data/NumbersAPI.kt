package com.example.kapkan.Data

import com.example.kapkan.Data.Retrofit.Numbers
import retrofit2.http.GET

interface NumbersAPI {
    @GET("blob/master/stringData")
    fun getAllNumbers(): Numbers
}