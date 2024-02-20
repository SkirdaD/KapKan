package com.example.kapkan.GameFragment

import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.example.kapkan.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout

class GameFragmentWidgetHolder(view: View) {

    val submitButton = view.findViewById<Button>(R.id.submit_button)
    val fabButton = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
    val hundokTextView = view.findViewById<TextView>(R.id.hundok)
    val translationTextView = view.findViewById<TextView>(R.id.translation)
    val answerEditText = view.findViewById<TextInputLayout>(R.id.answer_edit_text)
    val hanjaTextView = view.findViewById<TextView>(R.id.written_number_text_view)
    val numberOfWinsTextView = view.findViewById<TextView>(R.id.number_of_wins)
    val progressBar = view.findViewById<FrameLayout>(R.id.layout_for_progressBar)
}
