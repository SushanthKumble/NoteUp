package com.example.noteup.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteup.R
import com.example.noteup.databinding.ItemNoteBinding
import com.example.noteup.ui.fragments.HomeDirections
import com.example.noteup.ui.models.Note

class NotesAdapter(val context: Context) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    // DiffUtil
    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    private val asyncListDiffer = AsyncListDiffer(this, differCallback)

    fun submitList(data: List<Note>) {
        asyncListDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = asyncListDiffer.currentList[position]
        holder.binding.apply {
            notesTitle.text = data.title
            notesSubTitle.text = data.subTitle
            notesDetails.text = data.note
            noteDate.text = data.date

            when (data.priority) {
                "1" -> holder.binding.ViewPriority.setBackgroundResource(R.drawable.green)
                "2" -> holder.binding.ViewPriority.setBackgroundResource(R.drawable.yellow)
                "3" -> holder.binding.ViewPriority.setBackgroundResource(R.drawable.red)
            }

            holder.binding.root.setOnClickListener {
                val action = HomeDirections.actionHome2ToEditNote(data)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}
