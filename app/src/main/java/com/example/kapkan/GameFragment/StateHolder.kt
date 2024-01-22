package com.example.kapkan.GameFragment

import com.example.kapkan.Data.OldData.OldData
import com.example.kapkan.Data.Retrofit.NewData
import com.example.kapkan.Data.Retrofit.NumberData
import com.example.kapkan.Values
import kotlin.random.Random

class StateHolder(gameOptions: Values.GameOptions) {
    private val data = OldData()
    private val newData = NewData()
    //var n = newData.dataList

    var hintState = HintState.NOT_SHOWN

    enum class HintState { NOT_SHOWN, SHOWN_HUNDOK, SHOWN_BOTH }
    enum class Type { HANJA, NATIVE_NUMBERS, HANJA_SOUND, NUMBER_SOUND }

    var numberOfWins = 0

    var state = when (gameOptions) {
        Values.GameOptions.OPTION_1 -> Type.HANJA
        Values.GameOptions.OPTION_2 -> Type.HANJA_SOUND
        Values.GameOptions.OPTION_3 -> Type.NATIVE_NUMBERS
        Values.GameOptions.OPTION_4 -> Type.NUMBER_SOUND
    }
    var number = getRandomNumber()
    var hanja = getRandomHanja()


//    fun getN() {
//        newData.getNumbersData { dataList ->
//            n = dataList.numbers }
//    }

    fun updateNumber() {
        number = getRandomNumber()
    }

    fun updateHanja() {
        hanja = getRandomHanja()
    }


    // получаем пару (число цифрами/число хангылем)
//    private fun getRandomNumber(): Pair<Int, String> {
//        // берём рандомное число.
//        // fro korean
//        // last digit
//        val numberLD = Random.nextInt(1, 10)
//        val numberStringLD = newData.getAllNumbers(numberLD)
//        //val numberStringLD = data.koreanNumbers[numberLD]
//
//        // first digit
//
//        val numberFD = Random.nextInt(1, 10) * 10
//        val numberStringFD = data.koreanNumbers[numberFD]
//
//        val resultInt = numberFD + numberLD
//        val resultString = numberStringFD.toString() + " " + numberStringLD.toString()
//
//        return Pair(resultInt, resultString)
//    }

    private fun getRandomNumber(): NumberData {
        val numberLD = Random.nextInt(1, 10)
//        val numberStringLD = newData.allNumbers[numberLD]
        //val numberStringLD = data.koreanNumbers[numberLD]

        // first digit

//        val numberFD = Random.nextInt(1, 10) * 10
//        val numberStringFD = newData.allNumbers[numberFD]
//        //val numberStringFD = data.koreanNumbers[numberFD]
//
//        val resultInt = numberFD + numberLD
//        val resultString = numberStringFD.toString() + " " + numberStringLD.toString()

        return newData.dataList[0]//numberLD]
    }


    private fun getRandomHanja(): OldData.HanjaRecord {
        val list = data.hanjaNew
        return list[Random.nextInt(0, list.size)]
    }
}
