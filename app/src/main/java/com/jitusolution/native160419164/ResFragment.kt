package com.jitusolution.native160419164

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_res.*

class ResFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_res, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score =ResFragmentArgs.fromBundle(requireArguments()).score
        txtScore.setText("Your Score is $score")
        btnBack.setOnClickListener {
            val action= ResFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}