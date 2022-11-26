package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.tictactoe.databinding.FragmentGamechooseBinding

var singleUser = false
class gamechoose : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val bding: FragmentGamechooseBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_gamechoose, container, false)


        bding.singleBtn.setOnClickListener { view: View ->
            singleUser = true
            Navigation.findNavController(view).navigate(R.id.action_gamechoose_to_gameplay)
        }

        bding.twoplBtn.setOnClickListener { view: View ->
            singleUser = false
            Navigation.findNavController(view).navigate(R.id.action_gamechoose_to_gameplay)
        }
        return bding.root
    }

}
