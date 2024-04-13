package com.example.kapkan.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kapkan.Values
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewData(oldData: OldData) {
    var data = oldData
    var dataList = oldData.numbers

    fun fetchNumbersData(kapkanLiveData: MutableLiveData<NumbersData>) {
        val retrofit = Retrofit.Builder()
            .baseUrl(Values.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val numbersAPI = retrofit.create(NumbersAPI::class.java)
        val call: Call<NumbersData> = numbersAPI.getAllNumbers()


        call.enqueue(object : Callback<NumbersData> {
            override fun onResponse(
                call: Call<NumbersData>,
                response: Response<NumbersData>
            ) {
                if (response.isSuccessful) {
                    println("удачный запрос")
                    kapkanLiveData.postValue(response.body()!!)
                } else {
                    println("неудачный запрос")
                }
            }

            override fun onFailure(call: Call<NumbersData>, t: Throwable) {
                kapkanLiveData.postValue(data.numbers)
                t.message?.let { Log.e("ВОТ ОШИБКА", it) }
            }
        })
    }
}

typealias Hangul = String
typealias Hanja = String
typealias Russian = String
typealias English = String
