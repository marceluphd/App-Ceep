package br.com.alexf.ceep.ui.fragment

import br.com.alexf.ceep.R
import br.com.alexf.ceep.ui.recyclerview.adapter.NotesListAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.alexf.ceep.model.Note
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    private val notesList by lazy {
        notes_list_recyclerview
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        context?.let {
            notesList.adapter = NotesListAdapter(it, notes = listOf(
                    Note(title = "First title", description = "First description"),
                    Note(title = "Second title", description = "Second description")))
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
