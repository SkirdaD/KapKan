package com.example.kapkan.GameFragment

import android.view.View
import com.example.kapkan.Values
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameFragmentLogicHolder(
    private val widgets: GameFragmentWidgetHolder,
    gameOption: Values.GameOptions,
) {

    private val stateHolder = StateHolder(gameOption)

    fun initTextView() {
        widgets.hanjaTextView.text = when (stateHolder.state) {
            StateHolder.Type.HANJA -> stateHolder.hanja.syllable
            StateHolder.Type.HANJA_SOUND -> stateHolder.hanja.koreanSound
            StateHolder.Type.NATIVE_NUMBERS -> stateHolder.number.digit.toString()//first.toString()
            StateHolder.Type.NUMBER_SOUND -> stateHolder.number.nativeKoreanName.trim()//second
        }
    }

    fun submitButtonClickListener(@Suppress("UNUSED_PARAMETER") view: View) {

        val answer = when (stateHolder.state) {
            StateHolder.Type.HANJA -> stateHolder.hanja.koreanSound.trim()
            StateHolder.Type.HANJA_SOUND -> stateHolder.hanja.syllable.trim()
            StateHolder.Type.NATIVE_NUMBERS -> stateHolder.number.nativeKoreanName.trim()//second.trim()
            StateHolder.Type.NUMBER_SOUND -> stateHolder.number.digit.toString()//first.toString()
        }
        if (isAnswerRight(answer)) {
            onSuccessfulAnswer()
        }
    }

    fun errorIconClickListener(@Suppress("UNUSED_PARAMETER") view: View) {
        showTemporaryAnswerHint()
    }


    fun fabButtonClickListener(@Suppress("UNUSED_PARAMETER") view: View) {
        when (stateHolder.hintState) {
            StateHolder.HintState.NOT_SHOWN -> {
                showHundokHintFirstPress()
            }

            StateHolder.HintState.SHOWN_HUNDOK -> {
                showTranslationsOnSecondPress()
            }

            StateHolder.HintState.SHOWN_BOTH -> {
                //doNothingForNow
            }
        }
    }


    private fun showHundokHintFirstPress() {
        val isNotEmpty = stateHolder.hanja.hundok !in listOf("", "-")

        if (isNotEmpty) showHundokHint() else showTranslationsOnSecondPress()
    }

    private fun showTranslationsOnSecondPress() {
        val isNotEmpty = stateHolder.hanja.translationRU.isNotEmpty()

        if (isNotEmpty) showTranslationRuHint()
    }

    private fun showHundokHint() {
        widgets.hundokTextView.visibility = View.VISIBLE
        widgets.hundokTextView.text = stateHolder.hanja.hundok
        stateHolder.hintState = StateHolder.HintState.SHOWN_HUNDOK
    }

    private fun showTranslationRuHint() {
        widgets.translationTextView.visibility = View.VISIBLE
        widgets.translationTextView.text = stateHolder.hanja.translationRU.toString()
        stateHolder.hintState = StateHolder.HintState.SHOWN_BOTH
    }

    private fun isAnswerRight(answer: String): Boolean {
        return if (readFromEditText() == answer) {
            resetAnswerEditText()
            incrementNumberOfWins()
            true
        } else {
            showErrorMessage()
            false
        }
    }

    private fun readFromEditText(): String = widgets.answerEditText.editText?.text.toString().trim()
    private fun incrementNumberOfWins() {
        stateHolder.numberOfWins++
        widgets.numberOfWinsTextView.text = stateHolder.numberOfWins.toString()
    }


    private fun onSuccessfulAnswer() {
        updateTask()
        resetHints()
        initTextView()
    }
    private fun updateTask(){
        when (stateHolder.state) {
            StateHolder.Type.HANJA -> stateHolder.updateHanja()
            StateHolder.Type.HANJA_SOUND -> stateHolder.updateHanja()
            StateHolder.Type.NATIVE_NUMBERS -> stateHolder.updateNumber()
            StateHolder.Type.NUMBER_SOUND -> stateHolder.updateNumber()
        }
    }

    private fun resetHints() {
        stateHolder.hintState = StateHolder.HintState.NOT_SHOWN
        widgets.hundokTextView.visibility = View.GONE
        widgets.translationTextView.visibility = View.GONE
    }

    private fun resetAnswerEditText() {
        widgets.answerEditText.error = null
        widgets.answerEditText.editText?.text?.clear()
    }

    private fun showTemporaryAnswerHint() {
        CoroutineScope(Dispatchers.Main).launch {
            showHint()
            delay(Values.HINT_TIMEOUT)
            showBackTask()
        }
    }

    private fun showHint() {
        when (stateHolder.state) {
            StateHolder.Type.HANJA -> showKoreanSoundHanja()
            StateHolder.Type.HANJA_SOUND -> showHanja()
            StateHolder.Type.NATIVE_NUMBERS -> showNumberSound()
            StateHolder.Type.NUMBER_SOUND -> showNumber()
        }
    }

    private fun showBackTask() {
        when (stateHolder.state) {
            StateHolder.Type.HANJA -> showHanja()
            StateHolder.Type.HANJA_SOUND -> showKoreanSoundHanja()
            StateHolder.Type.NATIVE_NUMBERS -> showNumber()
            StateHolder.Type.NUMBER_SOUND -> showNumberSound()
        }
    }

    private fun showErrorMessage() {
        widgets.answerEditText.error = Values.ERROR_MESSAGE
    }

    private fun showKoreanSoundHanja() {
        widgets.hanjaTextView.text = stateHolder.hanja.koreanSound
    }

    private fun showHanja() {
        widgets.hanjaTextView.text = stateHolder.hanja.syllable
    }

    private fun showNumber() {
        widgets.hanjaTextView.text = stateHolder.number.digit.toString()//first.toString()
    }

    private fun showNumberSound() {
        widgets.hanjaTextView.text = stateHolder.number.nativeKoreanName//second
    }
}
