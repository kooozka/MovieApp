package edu.pwr.kozanecki.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
fun MovieCard(movie: Movie, index: Int) {
    Row {
        Text(text = "$index.",
            modifier = Modifier.padding(start = 6.dp),
            style = MaterialTheme.typography.titleMedium)
        Image(
            painter = painterResource(id = movie.imageSrc),
            contentDescription = "Photo",
            modifier = Modifier
                .padding(
                    vertical = 10.dp
                ).size(100.dp))
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

@Preview
@Composable
fun PreviewMovieCard() {
    MovieCard(movie = Movie("Nietykalni", "Intouchables 2011", R.drawable.nietykalni), index = 1)
}

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn {
        itemsIndexed(movies) {index, movie ->
            MovieCard(movie = movie, index = index + 1)
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