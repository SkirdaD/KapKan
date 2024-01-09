package com.example.kapkan.Data.Retrofit


data class HanjaRecord(
    val syllable: Hanja,
    val koreanSound: Hangul,
    val hundok: Hangul = "",
    val translationRU: List<Russian> = listOf(),
)
