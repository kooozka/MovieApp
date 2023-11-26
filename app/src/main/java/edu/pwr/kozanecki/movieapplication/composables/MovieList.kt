package edu.pwr.kozanecki.movieapplication.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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