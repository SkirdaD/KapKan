package com.example.kapkan.Data.Retrofit

import com.example.kapkan.Data.Hangul
import com.example.kapkan.Data.Hanja

data class NumberRecord(
    val digit: Int,
    val nativeKoreanName: Hanja,
    val sinoKoreanName: Hangul
)
