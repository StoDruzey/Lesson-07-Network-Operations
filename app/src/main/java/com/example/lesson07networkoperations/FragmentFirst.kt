package com.example.lesson07networkoperations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson07networkoperations.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFirstBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            //how to return data? Use parentFragmentManager and companion object
            parentFragmentManager
                .setFragmentResultListener(KEY_RESULT, viewLifecycleOwner) { _, bundle ->
                    editText.setText(bundle.getString(KEY_TEXT_RESULT))
                }

            button.setOnClickListener {
                val text = editText.text.toString()
// теперь вручную создаем SecondFragment и передаем аргумент из companion object из FragmentSecond
//т.к. данные передаются через MainActivity, то мы там создадим метод для переключения фрагментов
                val secondFragment = FragmentSecond.getInstance(text)

//now when getInstance method exists in FragmentSecond we can use it instead of commented code
//                apply {
//                    arguments = Bundle(1).apply {
//                        putString(FragmentSecond.KEY_TEXT, text)
//                    }
//                }
                addFragment(secondFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_RESULT = "key_result" //this is a key for fragmentResultListener
        const val KEY_TEXT_RESULT = "key_text_result" //this is a key for bundle for transfer data
    }
}