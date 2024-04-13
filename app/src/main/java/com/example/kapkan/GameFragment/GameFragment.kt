package com.example.kapkan.GameFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.kapkan.Data.OldData.OldData
import com.example.kapkan.Data.Retrofit.NewData
import com.example.kapkan.Data.Retrofit.NumbersData
import com.example.kapkan.R
import com.example.kapkan.Values

class GameFragment : Fragment() {

    companion object {
        fun newInstance(gameOptions: Values.GameOptions): GameFragment {
            val fragment = GameFragment()
            val args = Bundle()
            args.putString("gameOption", gameOptions.name)
            fragment.arguments = args
            return fragment
        }
    }

    val oldData = OldData()
    val newData = NewData(oldData)
    val kapkanLiveData = MutableLiveData<NumbersData>()

    private lateinit var gameOptions: Values.GameOptions

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        gameOptions = Values.GameOptions.valueOf(
            arguments?.getString("gameOption") ?: Values.GameOptions.HANJA_TO_TRANSCRIPTION.name
        )

        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val widgets = GameFragmentWidgetHolder(view)

        newData.fetchNumbersData(kapkanLiveData)

        kapkanLiveData.observe(viewLifecycleOwner) {

            widgets.progressBar.visibility = View.GONE


            newData.dataList = it

            val logicHolder = GameFragmentLogicHolder(widgets, gameOptions, newData, oldData)

            logicHolder.initTextView()

            widgets.submitButton.setOnClickListener(logicHolder::submitButtonClickListener)

            widgets.answerEditText.setErrorIconOnClickListener(logicHolder::errorIconClickListener)

            widgets.fabButton.setOnClickListener(logicHolder::fabButtonClickListener)
        }
    }
}
