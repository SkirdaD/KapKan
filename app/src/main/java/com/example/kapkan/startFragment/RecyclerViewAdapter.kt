package com.example.kapkan.startFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kapkan.R

class RecyclerViewAdapter(
    private val startList: List<String>,
    private val listener: OnRecyclerItemClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.start_list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = startList[position]
        holder.bindData(data)
        holder.setOnItemClickListener(position)
    }

    override fun getItemCount() = startList.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemTextView: TextView = itemView.findViewById(R.id.list_item)
        fun bindData(data: String) {
            itemTextView.text = data
        }

        fun setOnItemClickListener(position: Int) {
            itemView.setOnClickListener {
                listener.onItemClick(position)
            }
        }
    }

    interface OnRecyclerItemClickListener {
        fun onItemClick(position: Int)
    }
}