package com.example.noteapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.noteapp.data.Note
import com.example.noteapp.ui.theme.NoteAppTheme

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private val notes = mutableStateListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteApp(notes = notes) {
            }
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val title = data?.getStringExtra("title").orEmpty()
            val content = data?.getStringExtra("content").orEmpty()
            val isEditing = data?.getBooleanExtra("isEditing", false) ?: false

            if (isEditing) {
                val index = notes.indexOfFirst { it.title == title }
                if (index != -1) {
                    notes[index] = Note(title, content)
                }
            } else {
                notes.add(Note(title, content))
            }
        }
    }
}
