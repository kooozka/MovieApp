package edu.pwr.kozanecki.movieapplication.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Buttons(onScenesClick: () -> Unit, onActorsClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable { onScenesClick() }
                .border(1.dp, Color.Gray)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Scenes",
                style = MaterialTheme.typography.titleMedium)
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .clickable { onActorsClick() }
                .border(1.dp, Color.Gray)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Actors",
                style = MaterialTheme.typography.titleMedium)
        }
    }
}