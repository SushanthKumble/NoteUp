package com.example.noteup.ui.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.noteup.R
import com.example.noteup.databinding.FragmentCreateNoteBinding
import com.example.noteup.ui.models.Note
import com.example.noteup.ui.viewModels.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
@AndroidEntryPoint
class CreateNote : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding
    var priority:String="1"
    val viewmodel:NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)
        binding.pGreen.setImageResource(R.drawable.baseline_done_24)

        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener {
            priority = "2"
            binding.pYellow.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }

        binding.pRed.setOnClickListener {
            priority = "3"
            binding.pRed.setImageResource(R.drawable.baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }




        binding.btnSave.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_create_note_to_home2)
            createNotes(it)
        }


        return binding.root
    }

    private fun createNotes(it: View?) {
        val title=binding.editTitle.text.toString()
        val subtitle=binding.editSubtitle.text.toString()
        val note=binding.editTextNotes.text.toString()
        val d = Date()
        val notesDate: String = DateFormat.format("MMMM d, yyyy ", d.time).toString()

        var data=Note(null,title,subtitle,note,notesDate,priority)

        viewmodel.addNotes(data)
        Toast.makeText(activity, "Its a toast!", Toast.LENGTH_SHORT).show()

    }
}