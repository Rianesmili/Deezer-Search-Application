package fr.mastersime.deezer_search_app.feature

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

@Composable
fun HomeView() {

    val homeViewModel: HomeViewModel = hiltViewModel()
    var text by remember { mutableStateOf("Hello") }

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
            item {
                RowListItem()
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun RowListItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Radio Head",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f),
            fontSize = 20.sp,
        )
        ColumnSideItem()
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnSideItem(
) {
    Column (
    ) {
        Text(
            text = "Amnesiac",
            overflow = TextOverflow.Ellipsis,
            // modifier = Modifier.weight(1f),
            fontSize = 20.sp,
        )
        Text(
            text = "4,48",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    RowListItem()
}