package edu.pwr.kozanecki.movieapplication.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.data.Actor

@Composable
fun ActorCard(actor: Actor) {
    Row (
        modifier = Modifier
            .fillMaxWidth()) {
        Image(
            painter = painterResource(id = actor.imageSrc),
            contentDescription = "Photo ${actor.firstName} ${actor.secondName}",
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 6.dp)
                .size(80.dp))
        Column {
            Text(
                text = actor.firstName + " " + actor.secondName,
                modifier = Modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(text = actor.character,
                style = MaterialTheme.typography.titleSmall)
        }
    }
}