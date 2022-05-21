package com.azhar.fragmenttofragmentcommunication.viaInterface

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.azhar.fragmenttofragmentcommunication.databinding.FragmentABinding


class FragmentA : Fragment() {
    lateinit var binding: FragmentABinding

    private var listener: FragmentAListener? = null

    interface FragmentAListener {
        fun onInputASent(input: CharSequence?)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)

        binding.buttonOk.setOnClickListener(View.OnClickListener {
            val input: CharSequence = binding.editText.text.toString()
            listener?.onInputASent(input)
        })

        return binding.root
    }

    fun updateEditText(newText: CharSequence?) {
        binding.editText.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FragmentAListener) {
            context
        } else {
            throw RuntimeException(
                context.toString()
                    .toString() + " must implement FragmentAListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}