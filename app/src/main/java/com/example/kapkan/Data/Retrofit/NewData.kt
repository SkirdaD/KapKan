package com.example.kapkan.Data.Retrofit

import com.example.kapkan.Data.OldData.OldData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewData {
    val oldData = OldData()
    var dataList = oldData.numbers//getNumbersData()
    init {
        getNumbersData()
    }

    fun getNumbersData(){//: List<NumberData> {//callback: (NumbersData) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/products/")//https://github.com/russabit/KapKan/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val numbersAPI = retrofit.create(NumbersAPI::class.java)
        val call: Call<List<NumberData>> = numbersAPI.getAllNumbers()


        call.enqueue(object : Callback<List<NumberData>> {
            override fun onResponse(
                call: Call<List<NumberData>>,
                response: Response<List<NumberData>>
            ) {
                if (response.isSuccessful) {
                    dataList = response.body()!!
                    println("kKKKKKKKKKKKKKKKKK")
//                        if (dataList != null) {
////                            callback(dataList)
//                        }
//                    } else {
//                        // обработка ошибок
//                    }
                }
            }

            override fun onFailure(call: Call<List<NumberData>>, t: Throwable) {
               dataList = oldData.numbers
                // обработка ошибок
            }
        })
//        Thread.sleep(10000)
//        return dataList
    }
}


//    fun getNumbersData(): NumbersData {
//
//        var dataList = NumbersData(oldData.numbers)
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://github.com/russabit/KapKan/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//
//        val callback = object : Callback<NumbersData> {
//
//            override fun onResponse(
//                call: Call<NumbersData>,
//                response: Response<NumbersData>
//            ) {
//                if (response.isSuccessful) {
//                    dataList = response.body()!!
//                    println("response " + response.body())
//                } else {
//                    println("response code " + response.code())
//                }
//            }
//
//            override fun onFailure(call: Call<NumbersData>, t: Throwable) {
//                //dataList = NumbersData(oldData.numbers)
//                println("failure " + t)
//            }
//        }
//
//        retrofit.create(NumbersAPI::class.java)
//            .getAllNumbers()
//            .enqueue(callback)
//
//        return dataList
//    }

// ПОПЫТКА №1
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

//ПОПЫТКА №2
//    private fun getDataFromApi(): Response<NumbersData> {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://github.com/russabit/KapKan/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(NumbersAPI::class.java)
//        val call = service.getAllNumbers()
//
//        return call.execute()
//    }
//
//    fun getNumbersList(): NumbersData {
//        val dataList: NumbersData
//        val response = getDataFromApi()
//
//        if (response.isSuccessful) {
//            dataList = response.body()!!
//
////            if (dataList != null) {
////                for (data in dataList) {
////                    // далее можно обрабатывать каждый элемент списка data
////                }
////            } else {
////                // Обработка случая, когда данные null
////            }
//        } else {
//            // Обработка ошибочного ответа
//            val errorBody = response.errorBody()?.string()
//            dataList = NumbersData(oldData.numbers)
//            // Другие действия при ошибке
//        }
//        return dataList
//    }


typealias Hangul = String
typealias Hanja = String
typealias Russian = String
typealias English = String
