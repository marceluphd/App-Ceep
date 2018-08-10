package br.com.alexf.ceep.ui.activity

import android.os.Bundle
import br.com.alexf.ceep.R
import br.com.alexf.ceep.extension.transaction
import br.com.alexf.ceep.model.Note
import br.com.alexf.ceep.ui.NOTE_KEY
import br.com.alexf.ceep.ui.fragment.NoteFormFragment
import br.com.alexf.ceep.ui.fragment.NotesListFragment

class NoteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.transaction {
            val fragment = NotesListFragment()
            with(fragment) {
                onNoteClickListener = {
                    openNoteForm(it)
                }
                onAddNoteFabClickListener = {
                    openNoteForm()
                }
            }
            replace(R.id.activity_note_framelayout, fragment, null)
        }
    }

    private fun openNoteForm(note: Note? = null) {
        supportFragmentManager.transaction(addToBackStack = true) {
            val noteFormFragment = NoteFormFragment()
            note?.let { addNoteArgument(note, noteFormFragment) }
            replace(R.id.activity_note_framelayout, noteFormFragment, null)
            supportActionBar?.let {
                showBackButton(actionBar = it, show = true)
            }
        }

    }

    private fun addNoteArgument(note: Note, noteFormFragment: NoteFormFragment) {
        val args = Bundle()
        args.putParcelable(NOTE_KEY, note)
        noteFormFragment.arguments = args
    }

}