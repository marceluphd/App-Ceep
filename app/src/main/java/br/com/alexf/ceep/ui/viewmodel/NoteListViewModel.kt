package br.com.alexf.ceep.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.alexf.ceep.model.Note

class NoteListViewModel : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    init {
        _notes.postValue(exampleNoteList())
    }

    private fun exampleNoteList() = mutableListOf(
            Note(title = "First title", description = "First description"),
            Note(title = "Second title", description = "Second description"))

    fun add(note: Note) {
        val notes = _notes.value?.toMutableList() ?: mutableListOf()
        notes.add(note)
        _notes.postValue(notes)
    }
}