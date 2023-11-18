package edu.pwr.kozanecki.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.ui.theme.MovieApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieList(movies = SampleData.moviesList)
                }
            }
        }
    }
}

data class Movie(val title: String, val originalTitle: String, val imageSrc: Int)

@Composable
fun MovieCard(movie: Movie) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(id = movie.imageSrc), contentDescription = "Main picture",
            modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(text = movie.originalTitle,
                style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview
@Composable
fun PreviewMovieCard() {
    MovieCard(movie = Movie("Nietykalni", "Intouchables 2011", R.drawable.nietykalni))
}

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun PreviewMovieList() {
    MovieApplicationTheme {
        MovieList(movies = SampleData.moviesList)
    }
}