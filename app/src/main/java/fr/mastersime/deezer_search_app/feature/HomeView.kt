package fr.mastersime.deezer_search_app.feature

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.mastersime.deezer_search_app.data.entities.AuthorEntity

@Composable
fun HomeView() {

    val homeViewModel: HomeViewModel = hiltViewModel()
    var text by remember { mutableStateOf("") }

    val songs by homeViewModel.authorList.observeAsState(initial = emptyList())


    Column(Modifier.fillMaxSize()) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter artiste name") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                homeViewModel.updateData(text)
                Log.d("","Hello from click sur le bouton")
            },
            content = {
                Text(text = "Search Track")
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(songs) { song ->
                RowListItem(song)
            }
        }
    }


}

@Composable
fun RowListItem(song: AuthorEntity) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = song.title ?: "",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f),
            fontSize = 20.sp,
        )
        ColumnSideItem(song)
    }
}

@Composable
fun ColumnSideItem(song: AuthorEntity) {
    Column (
    ) {
        Text(
            text = song.author ?: "",
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
        )
        Text(
            text = song.duration?.toString() ?: "",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    HomeView()
}