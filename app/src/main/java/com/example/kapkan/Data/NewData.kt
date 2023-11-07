package com.example.kapkan.Data

import com.example.kapkan.Data.Retrofit.NumberRecord
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewData {
        val allNumbers: List<NumberRecord> = fetchNumbers()

    private fun fetchNumbers(): List<NumberRecord> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://github.com/russabit/KapKan/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val numbersAPI = retrofit.create(NumbersAPI::class.java)
        return numbersAPI.getAllNumbers().numbers
    }
}

typealias Hangul = String
typealias Hanja = String
typealias Russian = String
typealias English = String