package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.tictactoe.databinding.FragmentHomeBinding


class homeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentHomeBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)


        binding.homegragbtn.setOnClickListener{view:View->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_gamechoose)

        }
        return binding.root
    }


}