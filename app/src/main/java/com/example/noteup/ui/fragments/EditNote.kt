package com.example.noteup.ui.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.noteup.R
import com.example.noteup.databinding.FragmentEditNoteBinding
import com.example.noteup.ui.models.Note
import com.example.noteup.ui.viewModels.NotesViewModel
import java.util.Date

class EditNote : Fragment() {

    val notes by navArgs<EditNoteArgs>()
    lateinit var binding:FragmentEditNoteBinding
    private var priority="1"
    val viewmodel:NotesViewModel by viewModels ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentEditNoteBinding.inflate(inflater,container,false)


        binding.editTitle.setText(notes.data.title)
        binding.editSubtitle.setText(notes.data.subTitle)
        binding.editNotes.setText(notes.data.note)
        when (notes.data.priority) {
            "1" -> {
                binding.pGreen.setImageResource(R.drawable.baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
            "2" -> {
                binding.pYellow.setImageResource(R.drawable.baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pGreen.setImageResource(0)
            }
            "3" -> {
                binding.pRed.setImageResource(R.drawable.baseline_done_24)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
        }

        //change priority
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

        binding.btnEditSaveNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_edit_note_to_home2)
            updateNote(it)

        }


        return binding.root
    }

    fun updateNote(it:View){
        val title=binding.editTitle.text.toString()
        val subtitle=binding.editSubtitle.text.toString()
        val note=binding.editNotes.text.toString()
        val d = Date()
        val notesDate: String = DateFormat.format("MMMM d, yyyy ", d.time).toString()

        val data= Note(notes.data.id,title,subtitle,note,notesDate,priority)
        viewmodel.updateNote(data)
        Toast.makeText(activity, "Notes Updated !", Toast.LENGTH_SHORT).show()
    }
}