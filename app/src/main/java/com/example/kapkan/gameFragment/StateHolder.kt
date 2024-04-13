package com.example.kapkan.gameFragment

import com.example.kapkan.Values
import com.example.kapkan.data.OldData
import com.example.kapkan.data.NewData
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

    private fun getRandomNumber(): Pair<Int, String> {

        val firstDigit = Random.nextInt(1, 10)
        val firstDigitHanja =
            newData.dataList.numbers[firstDigit].nativeKoreanName


        val secondDigit = Random.nextInt(1, 10)
        val secondDigitHanja = newData.dataList.numbers[secondDigit].nativeKoreanName


        val number = (firstDigit * 10) + secondDigit
        val resultString = "$firstDigitHanja $secondDigitHanja"

        return Pair(number, resultString)
    }

    private fun getRandomHanja(): OldData.HanjaRecord {
        val list = oldData.hanjaNew
        return list[Random.nextInt(0, list.size)]
    }
}
