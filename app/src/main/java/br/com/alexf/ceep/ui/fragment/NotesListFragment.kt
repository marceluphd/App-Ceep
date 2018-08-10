package br.com.alexf.ceep.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.alexf.ceep.R
import br.com.alexf.ceep.model.Note
import br.com.alexf.ceep.ui.recyclerview.adapter.NotesListAdapter
import br.com.alexf.ceep.ui.viewmodel.NoteListViewModel
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NotesListFragment : BaseFragment() {

    var onNoteClickListener: (Note) -> Unit = {}
    var onAddNoteFabClickListener: () -> Unit = {}
    private val viewModel: NoteListViewModel by lazy {
        ViewModelProviders.of(this).get(NoteListViewModel::class.java)
    }
    private val adapter by lazy {
        context?.let { context ->
            NotesListAdapter(
                    context = context,
                    onItemClickListener = { onNoteClickListener(it) })
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val createdView = inflater.inflate(R.layout.fragment_notes_list, container, false)
        createdView.notes_list_recyclerview.adapter = adapter
        createdView.notes_list_fab_add.setOnClickListener {
            //            onAddNoteFabClickListener()
            viewModel.add(Note(title = "alex", description = "felipe"))
        }
        return createdView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.notes.observe(this, Observer { notes ->
            notes?.let {
                adapter?.add(it)
            }
        })

    }


}


