package com.example.lesson07networkoperations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lesson07networkoperations.databinding.FragmentSwitchBinding

class FragmentSwitch : Fragment() {
    private var _binding: FragmentSwitchBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSwitchBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
//            switchBox.set
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val KEY_SWITCH = "key_switch"
        fun getInstance(switch: Boolean): FragmentSwitch {
            return FragmentSwitch().apply {
                arguments = bundleOf(
                    KEY_SWITCH to switch
                )
            }
        }
    }
}

