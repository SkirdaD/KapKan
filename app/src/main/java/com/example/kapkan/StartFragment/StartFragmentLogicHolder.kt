package com.example.kapkan.StartFragment

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kapkan.GameFragment.GameFragment
import com.example.kapkan.R
import com.example.kapkan.Values

class StartFragmentLogicHolder(
    view: View, var context: Context, private val fragmentManager: FragmentManager,
) {
    private val viewHolder: StartFragmentViewHolder
    private val recyclerView: RecyclerView

    init {
        viewHolder = StartFragmentViewHolder(view)
        recyclerView = viewHolder.recyclerView
    }

    fun setRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerViewAdapter(getStartList(), setListener())
    }

    private fun getStartList(): List<String> {
        return Values.GameOptions.values().map { it.interpretation }
    }

    private fun setListener(): RecyclerViewAdapter.OnRecyclerItemClickListener {
        return object : RecyclerViewAdapter.OnRecyclerItemClickListener {
            override fun onItemClick(position: Int) {
                showGameFragment(Values.GameOptions.values()[position])
            }
        }
    }

    fun showGameFragment(gameOption: Values.GameOptions) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment, GameFragment.newInstance(gameOption))
            .addToBackStack(null)
            .commit()
    }
}
