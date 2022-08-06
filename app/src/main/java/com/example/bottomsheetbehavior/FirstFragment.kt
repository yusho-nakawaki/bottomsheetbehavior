package com.example.bottomsheetbehavior

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import com.example.bottomsheetbehavior.databinding.FragmentFirstBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

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

        Log.d("aaa1111", "onCreateView")
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
            binding.foldTextView.textSize = ((10..20).random()).toFloat()
            binding.foldTextView.text = randomText

//            binding.foldTextView.post(Runnable {
//                val lineNum = binding.foldTextView.lineCount
//                binding.answerLineCountText.text = "lineCount: $lineNum"
//                Log.d("aaa111", "lineCount of randomText: $lineNum")
//            })
        }

        binding.foldTextView.viewTreeObserver.addOnGlobalLayoutListener (
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (binding.foldTextView.lineCount > 0) {
                        // 何かlayoutを変更するならremoveListenerしなきゃいけなく、private methodにしてbinding.foldTextButton.setOnClickListenerの時にも呼ぶ必要がある
//                        binding.foldTextView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        val lineCount = binding.foldTextView.lineCount
//                        binding.answerLineCountText.text = "lineCount: $lineCount"
                        if (lineCount > 3) {
                            binding.readMoreButton.visibility = View.VISIBLE
                        }
                        else {
                            binding.readMoreButton.visibility = View.GONE
                        }
                    }
                }
            }
        )

        binding.readMoreButton.setOnClickListener {
            Log.d("aaa111", "aaa: ${binding.foldTextView.lineCount}")
            Log.d("aaa111", "bbb: ${binding.foldTextView.maxLines}")
            if (1000 == binding.foldTextView.maxLines) {
                binding.foldTextView.maxLines = 3
                binding.readMoreButton.text = "もっと見る"
            }
            else {
                binding.foldTextView.maxLines = 1000
                binding.readMoreButton.text = "閉じる"
            }
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

        // ランダムで1行のみとかを表示
        if (4 <= (0..10).random()) {
            randomText = "これは1行のみのテキスト"
        }

        return  randomText
    }

    private fun expandableTextView() {

    }
}