package com.example.mynotes.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.model.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

   abstract fun getNoteDao() : NotesDao

    companion object {

        @Volatile
        private var instance: NoteDataBase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){

            instance?:
            createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDataBase::class.java,
            "note_db"
        ).build()

    }
}