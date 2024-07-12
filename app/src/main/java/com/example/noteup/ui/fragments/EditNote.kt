package com.example.noteup.ui.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.noteup.R
import com.example.noteup.databinding.FragmentEditNoteBinding
import com.example.noteup.ui.models.Note
import com.example.noteup.ui.viewModels.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class EditNote : Fragment(), MenuProvider {

    val notes by navArgs<EditNoteArgs>()
    lateinit var binding: FragmentEditNoteBinding
    private var priority = "1"
    val viewmodel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditNoteBinding.inflate(inflater, container, false)

        // Add the MenuProvider to the Fragment's lifecycle
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
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

        // Change priority
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
            updateNote()
        }

        return binding.root
    }

    private fun updateNote() {
        val title = binding.editTitle.text.toString()
        val subtitle = binding.editSubtitle.text.toString()
        val note = binding.editNotes.text.toString()
        val d = Date()
        val notesDate: String = DateFormat.format("MMMM d, yyyy ", d.time).toString()

        val data = Note(
            notes.data.id,
            title,
            subtitle,
            note,
            notesDate,
            priority
        )
        viewmodel.updateNote(data)
        Toast.makeText(activity, "Notes Updated !", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.delete) {
            val bottomSheet = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.delete_bottom_sheet, null)
            bottomSheet.setContentView(view)
            val btnConfirmDelete = view.findViewById<TextView>(R.id.delete_yes)
            btnConfirmDelete.setOnClickListener {
                // Perform delete action here
                viewmodel.deleteNote(notes.data.id)
                bottomSheet.dismiss()
                findNavController().navigate(R.id.action_edit_note_to_home2)
                Toast.makeText(activity, "Note Deleted", Toast.LENGTH_SHORT).show()
            }
            val btnNoDelete = view.findViewById<TextView>(R.id.delete_no)
            btnNoDelete.setOnClickListener{
//                Log.d("@@@@","clicked no")
                bottomSheet.dismiss()
            }

            bottomSheet.show()
            return true
        }
        return false
    }
}
