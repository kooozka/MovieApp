package edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.R
import edu.pwr.kozanecki.movieapplication.data.Movie

@Composable
fun MovieDetails(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(top = 20.dp)
    ) {
        Image(
            painter = painterResource(id = movie.imageSrc),
            contentDescription = stringResource(R.string.photo),
            modifier = Modifier
                .padding(8.dp)
                .size(120.dp, 170.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Text(
            text = movie.description,
            modifier = Modifier
                .padding(end = 5.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
    //Divider(color = Color.Gray, thickness = 1.dp)
}