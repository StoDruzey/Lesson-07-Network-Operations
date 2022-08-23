package com.example.lesson07networkoperations

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.graphics.Typeface
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.core.text.inSpans
import androidx.fragment.app.Fragment
import com.example.lesson07networkoperations.databinding.FragmentFirstDialogBinding

class FragmentFirstDialog : Fragment() {
    private var _binding: FragmentFirstDialogBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFirstDialogBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val colorValue = ContextCompat.getColor(requireContext(), R.color.teal_700)
            val neutralButtonText = buildSpannedString {
//                color(colorValue) {
//                    append("neutral")
//                }
//it is possible to apply several span types:
                inSpans(ForegroundColorSpan(colorValue), StyleSpan(Typeface.BOLD)) {
                    append("neutral")
                }
            }

            button.setOnClickListener {
//                AlertDialog.Builder(requireContext())
//                    .setTitle("title")
//                    .setMessage("message")
//                    .setCancelable(false) //to not close over window
//                    .setPositiveButton(android.R.string.ok) { _, _ ->
//
//                    }
//                    .setNegativeButton(android.R.string.cancel) { _, _ ->
//
//                    }
//                    .setNeutralButton(neutralButtonText) { _, _ ->
//
//                    }
//                    .show()
// it is possible to invoke data set dialog:
                DatePickerDialog(requireContext(),
                    {p0, p1, p2, p3 -> }, 2022, 11, 11)
                    .show()
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
