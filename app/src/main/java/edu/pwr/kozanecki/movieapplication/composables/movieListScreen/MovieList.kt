package edu.pwr.kozanecki.movieapplication.composables.movieListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.pwr.kozanecki.movieapplication.data.Movie

@Composable
fun MovieList(movies: List<Movie>, navController: NavController) {
    LazyColumn {
        itemsIndexed(movies) {index, movie ->
            MovieCard(movie = movie, index = index, navController = navController)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Composable
fun MovieCard(movie: Movie, index: Int, navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("movieDetails/$index") }) {
        Text(text = String.format("%02d.", index + 1),
            modifier = Modifier.padding(start = 6.dp),
            style = MaterialTheme.typography.titleMedium)
        Image(
            painter = painterResource(id = movie.imageSrc),
            contentDescription = "Photo",
            modifier = Modifier
                .padding(vertical = 10.dp)
                .size(100.dp))
        Column {
            Text(
                text = movie.title,
                modifier = Modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(text = movie.originalTitle,
                style = MaterialTheme.typography.titleSmall)
        }
    }
}