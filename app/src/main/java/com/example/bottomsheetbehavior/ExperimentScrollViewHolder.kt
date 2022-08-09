package com.example.bottomsheetbehavior

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheetbehavior.databinding.ViewHolderExperimentScrollBinding

class ExperimentScrollViewHolder private constructor(
    val binding: ViewHolderExperimentScrollBinding,
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup) = ExperimentScrollViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_holder_experiment_scroll,
                parent,
                false
            )
        )
    }

    fun bind(position: Int) {
        binding.textView.text = "TEXT: $position"
    }
}