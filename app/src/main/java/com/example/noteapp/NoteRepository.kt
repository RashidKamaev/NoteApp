package com.example.noteapp

import com.example.noteapp.data.Note

class NoteRepository {
    private val notes = mutableListOf<Note>()

    fun getAllNotes(): List<Note> = notes

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun updateNote(updatedNote: Note) {
        val index = notes.indexOfFirst { it.id == updatedNote.id }
        if (index != -1) { notes[index] = updatedNote
    }
}
    fun deleteNote(note: Note) {
        notes.remove(note)
    }
}