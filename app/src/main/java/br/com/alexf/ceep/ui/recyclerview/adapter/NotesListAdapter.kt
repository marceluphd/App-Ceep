package br.com.alexf.ceep.ui.recyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.alexf.ceep.R
import br.com.alexf.ceep.model.Note
import kotlinx.android.synthetic.main.note_item.view.*
import kotlin.properties.Delegates

class NotesListAdapter(
        private val context: Context,
        private val notes: MutableList<Note> = mutableListOf(),
        var onItemClickListener: (Note) -> Unit = {}) :
        RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createdView = LayoutInflater.from(context)
                .inflate(R.layout.note_item, parent, false)
        return ViewHolder(createdView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    fun add(notes: List<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView by lazy {
            itemView.note_item_title
        }
        private val description by lazy {
            itemView.note_item_description
        }

        private var note: Note by Delegates.observable(Note()) { _, _, newNote ->
            title.text = newNote.title
            description.text = newNote.description
        }

        init {
            itemView.setOnClickListener { onItemClickListener(note) }
        }

        fun bind(note: Note) {
            this.note = note
        }

    }

}
