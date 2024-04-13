package com.example.kapkan.GameFragment

import com.example.kapkan.Data.OldData.OldData
import com.example.kapkan.Data.Retrofit.NewData
import com.example.kapkan.Data.Retrofit.NumberData
import com.example.kapkan.Values
import kotlin.random.Random

class StateHolder(
    gameOptions: Values.GameOptions,
    private val newData: NewData,
    private val oldData: OldData
) {

    var hintState = HintState.NOT_SHOWN

    enum class HintState { NOT_SHOWN, SHOWN_HUNDOK, SHOWN_BOTH }
    enum class Type { HANJA, NATIVE_NUMBERS, HANJA_SOUND, NUMBER_SOUND }

    var numberOfWins = 0

    var state = when (gameOptions) {
        Values.GameOptions.HANJA_TO_TRANSCRIPTION -> Type.HANJA
        Values.GameOptions.TRANSCRIPTION_TO_HANJA -> Type.HANJA_SOUND
        Values.GameOptions.NUMBER_TO_TRANSCRIPTION -> Type.NATIVE_NUMBERS
        Values.GameOptions.TRANSCRIPTION_NUMBER -> Type.NUMBER_SOUND
    }
    var number = getRandomNumber()
    var hanja = getRandomHanja()

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
//        //val numberStringLD = oldData.koreanNumbers[numberLD]
//
//        // first digit
//
//        val numberFD = Random.nextInt(1, 10) * 10
//        val numberStringFD = oldData.koreanNumbers[numberFD]
//
//        val resultInt = numberFD + numberLD
//        val resultString = numberStringFD.toString() + " " + numberStringLD.toString()
//
//        return Pair(resultInt, resultString)
//    }

    private fun getRandomNumber(): NumberData {
        val numberLD = Random.nextInt(1, 10)
//        val numberStringLD = newData.dataList.numbers[numberLD]
        //val numberStringLD = oldData.koreanNumbers[numberLD]

        // first digit
//
//        val numberFD = Random.nextInt(1, 10) * 10
//        val numberStringFD = newData.allNumbers[numberFD]
//        //val numberStringFD = oldData.koreanNumbers[numberFD]
//
//        val resultInt = numberFD + numberLD
//        val resultString = numberStringFD.toString() + " " + numberStringLD.toString()

        return newData.dataList.numbers[numberLD]
    }


    private fun getRandomHanja(): OldData.HanjaRecord {
        val list = oldData.hanjaNew
        return list[Random.nextInt(0, list.size)]
    }
}
