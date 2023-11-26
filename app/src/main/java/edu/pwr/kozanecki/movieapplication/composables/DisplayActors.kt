package edu.pwr.kozanecki.movieapplication.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.data.Actor

@Composable
fun DisplayActors(actors: List<Actor>) {
    LazyColumn {
        items(actors) {actor ->
            ActorCard(actor = actor)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}