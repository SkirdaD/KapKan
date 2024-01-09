package com.example.kapkan.Data.Retrofit

import com.example.kapkan.Data.OldData.OldData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.Executors

class NewData {

    val oldData = OldData()

//    val executor = Executors.newSingleThreadExecutor()
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://github.com/russabit/KapKan/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    fun getNumbersList(): NumbersData {
//        val apiService = retrofit.create(NumbersAPI::class.java)
//        val request = apiService.getAllNumbers()
//
//        var dataList = NumbersData(oldData.numbers)
//
//        executor.execute {
//            try {
//                val response = request.execute()
//                if (response.isSuccessful) {
//                    dataList = response.body()!!
//                    // Обработка данных здесь
//                } else {
//                    // Обработка ошибки
//                }
//            } catch (e: IOException) {
//                e.printStackTrace()
//                // Обработка ошибки
//            }
//        }
//        return dataList
//    }


    private fun getDataFromApi(): Response<NumbersData> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://github.com/russabit/KapKan/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(NumbersAPI::class.java)
        val call = service.getAllNumbers()

        return call.enqueue(new Ca)//execute()
    }

    fun getNumbersList(): NumbersData {
        val dataList: NumbersData
        val response = getDataFromApi()

        if (response.isSuccessful) {
            dataList = response.body()!!

//            if (dataList != null) {
//                for (data in dataList) {
//                    // далее можно обрабатывать каждый элемент списка data
//                }
//            } else {
//                // Обработка случая, когда данные null
//            }
        } else {
            // Обработка ошибочного ответа
            val errorBody = response.errorBody()?.string()
            dataList = NumbersData(oldData.numbers)
            // Другие действия при ошибке
        }
        return dataList
    }
}

typealias Hangul = String
typealias Hanja = String
typealias Russian = String
typealias English = String
