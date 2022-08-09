package com.example.bottomsheetbehavior

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheetbehavior.databinding.FragmentThirdBinding

class ThirdFragment : Fragment()  {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ThirdAdapter().apply {
            items = listOf(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,1,1,1,1,1,1,1,1,1,1,1,1)
//            items = listOf(1,1,1,1,1,1,1)
        }

    }

}