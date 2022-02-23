package com.jitusolution.native160419164

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_res.*

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null){
           val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        var score =0
        var A= (0..100).random()
        var B= (0..100).random()
        Log.d('A'.toString(), A.toString())
        var C= A+B
        Log.d('C'.toString(), C.toString())
        txtNum1.setText(A.toString())
        txtNum2.setText(B.toString())
        btnSubmit.setOnClickListener{
            var answer = txtAnswer.text.toString()
            if(answer==C.toString()){
                var X= (0..100).random()
                var Y= (0..100).random()
                C= X+Y
                txtNum1.setText(X.toString())
                txtNum2.setText(Y.toString())
                score=score+1
                Log.d("score",score.toString())
               txtAnswer.setText("")
            }
            else{
                val totalscore= score.toString()
                val action= GameFragmentDirections.actionResFragment(totalscore)
                Navigation.findNavController(it).navigate(action)
            }
        }

        /*btnBack.setOnClickListener{
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
    }
}