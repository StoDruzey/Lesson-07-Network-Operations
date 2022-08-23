package com.example.lesson07networkoperations

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.lesson07networkoperations.databinding.FragmentCustomDialogBinding

class CustomDialog2 : DialogFragment() {
    private var _binding: FragmentCustomDialogBinding? = null
    private val binding get() = requireNotNull(_binding)

//it is possible to create dialog as AlertDialog (see below) instead of
//creating whole view (see commented code below):
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val layoutInflater = LayoutInflater.from(requireContext())
        return AlertDialog.Builder(requireContext())
            .setView(
                FragmentCustomDialogBinding
                    .inflate(layoutInflater, null, false)
                    .root
            )
//to cancel from AlertDialog create new button
            .setPositiveButton("ok") {_, _ ->

            }
            .create()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return FragmentCustomDialogBinding.inflate(inflater, container, false)
//            .also { _binding = it }
//            .root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        isCancelable = false
//        with(binding) {
//
//            button.setOnClickListener {
//                dismiss() //method to close the dialog
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}