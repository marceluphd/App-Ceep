package br.com.alexf.ceep.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.alexf.ceep.R
import br.com.alexf.ceep.model.Note
import br.com.alexf.ceep.ui.recyclerview.adapter.NotesListAdapter
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NotesListFragment : BaseFragment() {

    var onNoteClickListener: (Note) -> Unit = {}

    private val adapter by lazy {
        context?.let { context ->
            NotesListAdapter(context = context, notes = mutableListOf(
                    Note(title = "First title", description = "First description"),
                    Note(title = "Second title", description = "Second description"))) { clickedNote ->
                onNoteClickListener(clickedNote)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val createdView = inflater.inflate(R.layout.fragment_notes_list, container, false)
        createdView.notes_list_recyclerview.adapter = adapter
        return createdView
    }

}


