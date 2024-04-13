package com.example.kapkan.data


data class HanjaRecord(
    val syllable: Hanja,
    val koreanSound: Hangul,
    val hundok: Hangul = "",
    val translationRU: List<Russian> = listOf(),
)
