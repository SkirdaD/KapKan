package com.example.kapkan.Data

data class HanjaData(
    val syllable: Hanja,
    val koreanSound: Hangul,
    val hundok: Hangul = "",
    val translationRU: List<Russian> = listOf()
)
