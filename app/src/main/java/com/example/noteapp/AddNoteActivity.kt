//package com.example.noteapp
//
//import android.app.Activity
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//class AddNoteActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val RESULT_OK = -1
//        val noteTitle = intent.getStringExtra("title") ?: "Заголовок"
//        val noteContent = intent.getStringExtra("content") ?: ""
//        val isEditing = intent.getBooleanExtra("isEditing", false)
//
//        setContent {
//            var title by remember { mutableStateOf(noteTitle) }
//            var content by remember { mutableStateOf(noteContent) }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//            ) {
//                OutlinedTextField(
//                    value = title,
//                    onValueChange = { title = it },
//                    label = { Text("Заголовок") },
//                    singleLine = true
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                OutlinedTextField(
//                    value = content,
//                    onValueChange = { content = it },
//                    label = { Text("Текст заметки") },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                Button(
//                    onClick = {
//                        val intent = intent
//                        intent.putExtra("title", title)
//                        intent.putExtra("content", content)
//                        intent.putExtra("isEditing", isEditing)
//                        setResult(Activity.RESULT_OK, intent)
//                        finish()
//                    },
//                    modifier = Modifier.align(Alignment.End)
//                ) {
//                    Text(if (isEditing) "Обновить" else "Сохранить")
//                }
//            }
//        }
//    }
//}
