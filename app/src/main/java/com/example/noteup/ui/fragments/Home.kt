package com.example.noteup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.noteup.R
import com.example.noteup.databinding.FragmentHomeBinding

class Home : Fragment() {
    lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_create_note)
        }




        return binding.root
    }
}

