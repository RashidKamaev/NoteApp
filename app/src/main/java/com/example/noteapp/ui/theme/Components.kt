import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.Note
import com.example.noteapp.AddNoteActivity

@Composable
fun NoteApp(notes: List<Note>, onAddNote: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onAddNote() }) {
                Text("+", fontSize = 24.sp, color = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(notes) {note ->
                NoteCard(note)
            }
        }
    }
}

@Composable
fun NoteCard(note: Note) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                val intent = Intent(context, AddNoteActivity::class.java).apply {
                    putExtra("title", note.title)
                    putExtra("content", note.content)
                    putExtra("isEditing", true)
                }
                context.startActivity(intent)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = note.title, fontSize = 12.sp, color = Color.White)
            Text(
                text = if (note.content.length > 300) {
                    "${note.content.substring(0, 300)}..."
                } else note.content,
                fontSize = 10.sp,
                color = Color(0xFFBFBFBF),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}