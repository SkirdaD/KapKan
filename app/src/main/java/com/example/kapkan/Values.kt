package com.example.kapkan

class Values {
    companion object {
        const val HINT_TIMEOUT: Long = 5000
        const val ERROR_MESSAGE = "that's not right!"
    }

    enum class GameOptions(var interpretation: String) {
        HANJA_TO_TRANSCRIPTION("Hanja To Transcription"),
        TRANSCRIPTION_TO_HANJA("Transcription To Hanja"),
        NUMBER_TO_TRANSCRIPTION("Number To Transcription"),
        TRANSCRIPTION_NUMBER("Transcription To Number")
    }
}