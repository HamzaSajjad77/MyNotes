package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mynotes.databinding.ActivityMainBinding
import com.example.mynotes.db.NoteDataBase
import com.example.mynotes.repository.NoteRepository
import com.example.mynotes.viewmodel.NoteViewModel
import com.example.mynotes.viewmodel.NoteViewModelProviderFactory



class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }

    private fun setUpViewModel(){
        val noteRepository = NoteRepository(
            NoteDataBase(this)
        )

        val viewModelProviderFactory =
            NoteViewModelProviderFactory(
                application,
                noteRepository
            )
        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }

}