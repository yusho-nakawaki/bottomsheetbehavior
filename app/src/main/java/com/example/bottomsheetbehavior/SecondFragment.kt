package com.example.bottomsheetbehavior

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import com.example.bottomsheetbehavior.databinding.FragmentSecondBinding
import com.example.bottomsheetbehavior.jetpack.JetpackComposeActivity

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
//            val intent = JetpackComposeActivity.createIntent(requireContext())
//            startActivity(intent)
        }

        binding.openTextButton.setOnClickListener {
            if (binding.scrollText.measuredHeight == binding.textView.measuredHeight) {
                val expandTextAnimator = ValueAnimator.ofFloat(binding.scrollText.measuredHeight.toFloat(), 150*(requireContext().resources.displayMetrics.density))
                expandTextAnimator.duration = 500L
                Log.d("aaa111", "Float: ${150*(requireContext().resources.displayMetrics.density)}")
                Log.d("aaa111", "Int: ${150*(requireContext().resources.displayMetrics.density).toInt()}")
                Log.d("aaa111", "Float to Int: ${(150*(requireContext().resources.displayMetrics.density)).toInt()}")
                expandTextAnimator.addUpdateListener {
                    val animatedValue = expandTextAnimator.animatedValue as? Float ?: return@addUpdateListener
                    val layoutParams = binding.scrollText.layoutParams
                    layoutParams.height = animatedValue.toInt()
                    binding.scrollText.layoutParams = layoutParams
                }
                expandTextAnimator.start()
            }
            else {
                val expandTextAnimator = ValueAnimator.ofInt(binding.scrollText.measuredHeight, binding.textView.measuredHeight)
                expandTextAnimator.duration = 500L
                expandTextAnimator.addUpdateListener {
                    val animatedValue = expandTextAnimator.animatedValue as Int
                    val layoutParams = binding.scrollText.layoutParams
                    layoutParams.height = animatedValue
                    binding.scrollText.layoutParams = layoutParams
                }
                expandTextAnimator.start()
            }
        }

//        binding.rankComposeView.setContent {
//            ProfileEditPage()
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}