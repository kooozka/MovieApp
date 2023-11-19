package edu.pwr.kozanecki.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.pwr.kozanecki.movieapplication.ui.theme.MovieApplicationTheme

class MovieDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showScenes by remember { mutableStateOf(true) }
            MovieApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val index =  intent.getIntExtra("index", -1)
                    Column {
                        MovieDetails(movie = SampleData.moviesList[index])
                        Buttons(showScenes = true, onScenesClick = { showScenes = true }, onActorsClick = {showScenes = false})
                        if (showScenes) DisplayScenes(movieScenes = SampleData.moviesList[index].scenes) else Text(text = "gowno")
                    }
                }
            }
        }
    }
}

@Composable
fun MovieDetails(movie: Movie) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = movie.imageSrc),
                contentDescription = "Photo",
                modifier = Modifier
                    .size(170.dp)
                    .padding(top = 7.dp)
            )
            Text(
                text = movie.description,
                modifier = Modifier
                    .padding(end = 5.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Divider(color = Color.Gray, thickness = 1.dp)
    }
}

@Composable
fun Buttons(showScenes: Boolean, onScenesClick: () -> Unit, onActorsClick: () -> Unit) {
    Row (modifier = Modifier.padding(16.dp)) {
        Button(onClick = { onScenesClick }
        ) {
            Text(text = "Scenes")
        }
        Button(onClick = { onActorsClick }
        ) {
            Text(text = "Actors")
        }
    }
}

@Composable
fun DisplayScenes(movieScenes: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
//        contentPadding = PaddingValues(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movieScenes.size) { index ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = movieScenes[index]),
                    contentDescription = "Photo $index",
                    modifier = Modifier.fillMaxSize()
                )
            }

        }
    }
}

@Composable
fun Greeting(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieApplicationTheme {
        Greeting("Android")
    }
}