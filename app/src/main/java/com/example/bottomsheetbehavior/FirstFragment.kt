package com.example.bottomsheetbehavior

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bottomsheetbehavior.databinding.FragmentFirstBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val behavior = BottomSheetBehavior.from(binding.bottomSheet)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN

//        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            if (behavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            if (behavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        // 実際に実装するとしたらこれかな
        binding.foldTextButton.setOnClickListener {
            val randomText = randomText()
            binding.foldTextView.textSize = ((10..16).random()).toFloat()
            binding.foldTextView.text = randomText

            viewLifecycleOwner.lifecycleScope.launch {
                delay(200)
                val lineNum = binding.foldTextView.lineCount
                binding.answerLineCountText.text = "lineCount: $lineNum"
                Log.d("aaa111", "lineCount of randomText: $lineNum")

                // 3行目がtextの何番目か？
                val textIndex = binding.foldTextView.layout.getLineStart(3) - 1//gain
                binding.answerThreeLineHeightText.text = "textIndex: $textIndex"
                Log.d("aaa111", "height at 3 line: $textIndex")
            }

//            val lineNum = binding.foldTextView.lineCount
//            binding.answerText.text = "lineCount: $lineNum"
//            Log.d("aaa111", "lineCount of randomText: $lineNum")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun randomText(): String {
        val text = "１２３４５６７８９」"
        val newLine = "\n"
        var randomText = ""
        for (i in 1..5) {
            for (j in 1..(1..5).random()) {
                randomText += text
            }
            if (4 < (0..10).random()) {
                if (i == 5) break
                for (j in 0..(0..4).random()) {
                    randomText += newLine
                }
            }
        }
        return  randomText
    }
}