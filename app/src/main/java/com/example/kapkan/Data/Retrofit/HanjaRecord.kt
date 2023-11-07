package com.example.kapkan.Data.Retrofit

import com.example.kapkan.Data.Hangul
import com.example.kapkan.Data.Hanja
import com.example.kapkan.Data.Russian

data class HanjaRecord(
    val syllable: Hanja,
    val koreanSound: Hangul,
    val hundok: Hangul = "",
    val translationRU: List<Russian> = listOf(),
)
