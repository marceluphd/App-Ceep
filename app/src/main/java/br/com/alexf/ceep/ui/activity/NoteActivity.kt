package br.com.alexf.ceep.ui.activity

import br.com.alexf.ceep.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alexf.ceep.extension.transaction
import br.com.alexf.ceep.ui.fragment.NotesListFragment

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        supportFragmentManager.transaction {
            replace(R.id.activity_note_framelayout, NotesListFragment(), null)
        }
    }

}
