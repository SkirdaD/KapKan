package com.example.kapkan.Data

import retrofit2.http.GET

interface HanjaAPI {
    @GET("http")
    fun getHanja(): HanjaData
}