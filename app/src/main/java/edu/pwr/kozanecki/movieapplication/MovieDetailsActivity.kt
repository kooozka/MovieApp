package edu.pwr.kozanecki.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            MovieApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val index =  intent.getIntExtra("index", -1)
                    MovieDetails(movie = SampleData.moviesList[index])
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