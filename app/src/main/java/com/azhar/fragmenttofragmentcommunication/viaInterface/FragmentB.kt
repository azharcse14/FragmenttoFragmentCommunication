package com.azhar.fragmenttofragmentcommunication.viaInterface

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.azhar.fragmenttofragmentcommunication.databinding.FragmentBBinding


class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding
    private var listener: FragmentBListener? = null

    interface FragmentBListener {
        fun onInputBSent(input: CharSequence?)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater, container, false)

        binding.buttonOk.setOnClickListener(View.OnClickListener {
            val input: CharSequence = binding.editText.text.toString()
            listener!!.onInputBSent(input)
        })

        return binding.root
    }

    fun updateEditText(newText: CharSequence?) {
        binding.editText.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FragmentBListener) {
            context
        } else {
            throw RuntimeException(
                context.toString()
                    .toString() + " must implement FragmentBListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}