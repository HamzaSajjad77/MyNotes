package com.example.mynotes.repository

import com.example.mynotes.db.NoteDataBase
import com.example.mynotes.model.Note

class NoteRepository(private val db : NoteDataBase) {

    suspend fun addNote(note: Note) = db.getNoteDao().addNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    fun getAllNotes() = db.getNoteDao().getAllNotes()

}