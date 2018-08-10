package br.com.alexf.ceep.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import br.com.alexf.ceep.R
import br.com.alexf.ceep.model.Note
import br.com.alexf.ceep.ui.NOTE_KEY
import kotlinx.android.synthetic.main.fragment_note_form.*

class NoteFormFragment : BaseFragment() {

    private val title: EditText by lazy {
        fragment_note_form_title
    }

    private val description: EditText by lazy {
        fragment_note_form_description
    }

    private lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeNote()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillFields()
    }

    private fun initializeNote() {
        arguments?.let { bundle ->
            bundle.getParcelable<Note>(NOTE_KEY)?.let { receivedNote ->
                this.note = receivedNote
                return
            }
        }
        this.note = Note()
    }

    private fun fillFields() {
        if (::note.isInitialized) {
            title.setText(note.title)
            description.setText(note.description)
        }
    }

}