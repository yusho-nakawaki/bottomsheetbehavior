package com.example.bottomsheetbehavior

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ThirdAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<Int> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
//    var itemClickListener: (() -> Unit)? = null

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ExperimentScrollViewHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ExperimentScrollViewHolder -> {
                holder.bind(position)
//                holder.itemView.setOnClickListener {
//                    itemClickListener?.invoke(items.filter { it.type == AdapterItemBindModel.Type.APP }.indexOf(items[position]))
//                }
            }
            else -> throw IllegalArgumentException("unknown view holder $holder")
        }
    }
}