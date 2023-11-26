package edu.pwr.kozanecki.movieapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.pwr.kozanecki.movieapplication.ui.theme.MovieApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApplicationTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "movieList") {
                    composable("movieList") {
                        MovieListScreen(navController = navController)
                    }
                    composable("movieDetails/{index}", arguments = listOf(navArgument("index") {type = NavType.IntType})) {
                            backStackEntry ->
                        val index = backStackEntry.arguments?.getInt("index")
                        if(index != null) {
                            MovieDetailsScreen(index = index)
                        }
                    }
                }
            }
        }
    }
}

data class Movie(val title: String, val originalTitle: String, val imageSrc: Int, val description: String, val scenes: List<Int>, val actors: List<Actor>)
data class Actor(val firstName: String, val secondName: String, val character: String, val imageSrc: Int)

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

@Composable
fun MovieList(movies: List<Movie>, navController: NavController) {
    LazyColumn {
        itemsIndexed(movies) {index, movie ->
            MovieCard(movie = movie, index = index, navController = navController)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(navController: NavController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Movie List") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary)
                )
            }
        ) {innerPadding -> Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            MovieList(movies = SampleData.moviesList, navController = navController)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(index: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movie List") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) {innerPadding -> Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        color = MaterialTheme.colorScheme.background
    ) {
    var showScenes by remember { mutableStateOf(true) }
            Column {
                MovieDetails(movie = SampleData.moviesList[index])
                Buttons(
                    onScenesClick = { showScenes = true },
                    onActorsClick = { showScenes = false })
                if (showScenes) DisplayScenes(movieScenes = SampleData.moviesList[index].scenes) else DisplayActors(
                    actors = SampleData.moviesList[index].actors
                )
            }
        }
    }
}

@Composable
fun DisplayScenes(movieScenes: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
//        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
//       verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movieScenes.size) { index ->
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .size(180.dp)
//                    .border(1.dp, Color.Black)
//            ) {
////                Row {
////                    Text(text = index.toString())
////                }
                Image(
                    painter = painterResource(id = movieScenes[index]),
                    contentDescription = "Photo $index",
                    modifier = Modifier
                        .size(135.dp)
                        .fillMaxSize()
                )
            }

        }
    }


@Composable
fun DisplayActors(actors: List<Actor>) {
    LazyColumn {
        items(actors) {actor ->
            ActorCard(actor = actor)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Composable
fun ActorCard(actor: Actor) {
    Row (
        modifier = Modifier
            .fillMaxWidth()) {
        Image(
            painter = painterResource(id = actor.imageSrc),
            contentDescription = "Photo ${actor.firstName} ${actor.secondName}",
            modifier = Modifier
                .padding(vertical = 10.dp)
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
    //Divider(color = Color.Gray, thickness = 1.dp)
}

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








