package com.example.noteapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.Note

class NoteViewModel: ViewModel() {
    private val repository = NoteRepository()
    private var notes = mutableStateOf<List<Note>>(emptyList())

        private set

    init {
        notes.value = repository.getAllNotes()
    }

    fun addNote(note: Note) {
        repository.addNote(note)
        notes.value = notes.value + note
    }
    fun updateNote(note: Note) {
        val index = notes.value.indexOfFirst { it.id == note.id }
        if (index != -1) {
            notes.value = notes.value.toMutableList().apply {
                this[index] = note
            }
        }
    }
}