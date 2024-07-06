package com.example.noteup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteup.R
import com.example.noteup.databinding.FragmentHomeBinding
import com.example.noteup.ui.adapters.NotesAdapter
import com.example.noteup.ui.viewModels.NotesViewModel

class Home: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: NotesViewModel by viewModels()
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        // Observe all notes initially
        viewModel.getAllNotes().observe(viewLifecycleOwner, Observer { notesList ->
            notesAdapter.submitList(notesList)
        })

        // Navigate to create note screen
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_create_note)
        }

        // Reset to display all notes
        binding.ivFilter.setOnClickListener {
            viewModel.getAllNotes().observe(viewLifecycleOwner, Observer { notesList ->
                notesAdapter.submitList(notesList)
            })
            Toast.makeText(activity, "All Notes!", Toast.LENGTH_SHORT).show()
        }

        // Handle High priority click
        binding.tvHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner, Observer { highPriorityNotes ->
                notesAdapter.submitList(highPriorityNotes)

            })
            Toast.makeText(activity, "High Priority Notes  !", Toast.LENGTH_SHORT).show()
        }

        // Handle Medium priority click
        binding.tvMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner, Observer { mediumPriorityNotes ->
                notesAdapter.submitList(mediumPriorityNotes)
            })
            Toast.makeText(activity, "Medium Priority Notes !", Toast.LENGTH_SHORT).show()
        }

        // Handle Low priority click
        binding.tvLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner, Observer { lowPriorityNotes ->
                notesAdapter.submitList(lowPriorityNotes)
            })
            Toast.makeText(activity, "Low Priority Notes !", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        notesAdapter = NotesAdapter(requireContext())
        binding.recAllNotes.apply {
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter = notesAdapter
        }
    }
}
