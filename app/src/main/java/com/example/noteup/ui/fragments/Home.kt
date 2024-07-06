package com.example.noteup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteup.R
import com.example.noteup.databinding.FragmentHomeBinding
import com.example.noteup.ui.adapters.NotesAdapter
import com.example.noteup.ui.viewModels.NotesViewModel

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: NotesViewModel by viewModels()
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
            notesAdapter.submitList(notesList)
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_create_note)
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        notesAdapter = NotesAdapter(requireContext())
        binding.recAllNotes.apply {
            binding.recAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = notesAdapter
        }
    }
}
