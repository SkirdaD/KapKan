package com.example.kapkan.Data.Retrofit

import androidx.lifecycle.MutableLiveData
import com.example.kapkan.Data.OldData.OldData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewData {
    val oldData = OldData()
    var dataList  = oldData.numbers

    fun fetchNumbersData(kapkanLiveData: MutableLiveData<List<NumberData>>) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://github.com/russabit/KapKan/")
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
                    println("удачный запрос")
                    kapkanLiveData.postValue(response.body()!!)
//                        if (dataList != null) {
////                            callback(dataList)
//                        }
                    } else {
                    println("неудачный запрос")

//                        // обработка ошибок
//                    }
                }
            }

            override fun onFailure(call: Call<List<NumberData>>, t: Throwable) {
                kapkanLiveData.postValue(oldData.numbers)
                // обработка ошибок
            }
        })
    }
}

typealias Hangul = String
typealias Hanja = String
typealias Russian = String
typealias English = String
