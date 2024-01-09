package com.example.kapkan.GameFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kapkan.R
import com.example.kapkan.Values

class GameFragment(private val gameOption: Values.GameOptions) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val widgets = GameFragmentWidgetHolder(view)
        val logicHolder = GameFragmentLogicHolder(widgets, gameOption)
//        val data = NewData()
//
//        runBlocking {
//            val responseData = withContext(Dispatchers.IO) {
//                RetrofitClient.apiService.getAllNumbers()
//            }
//            data.allNumbers = responseData;
//        }

        logicHolder.initTextView()

        widgets.submitButton.setOnClickListener(logicHolder::submitButtonClickListener)

        widgets.answerEditText.setErrorIconOnClickListener(logicHolder::errorIconClickListener)

        widgets.fabButton.setOnClickListener(logicHolder::fabButtonClickListener)
    }
}
