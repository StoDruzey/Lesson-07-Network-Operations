package com.example.lesson07networkoperations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lesson07networkoperations.databinding.FragmentFirstBinding
import com.example.lesson07networkoperations.databinding.FragmentSecondBinding

class FragmentSecond : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSecondBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//to transfer data to FirstFragment we invoke parentFragmentManager:
        parentFragmentManager
            .setFragmentResult(
                FragmentFirst.KEY_RESULT,
                bundleOf(
                    FragmentFirst.KEY_TEXT_RESULT to ""
                )
            )

        with(binding) {

        }

        binding.editText.setText(requireArguments().getString(KEY_TEXT))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val KEY_TEXT = "key_text"
        //чтобы ключ из 2го фрагмента случайно не оказался где-то в 1м, обычно создается фабрика фрагментов:
        fun getInstance(text: String): FragmentSecond {
            return FragmentSecond().apply {
                arguments = bundleOf(
                    KEY_TEXT to text
                )
            }
        }
    }
}