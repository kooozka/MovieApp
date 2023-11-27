package edu.pwr.kozanecki.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.pwr.kozanecki.movieapplication.composables.movieDetailsScreen.MovieDetailsScreen
import edu.pwr.kozanecki.movieapplication.composables.movieListScreen.MoviesListScreen
import edu.pwr.kozanecki.movieapplication.ui.theme.MovieApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApplicationTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "movieList") {
                    composable("movieList") {
                        MoviesListScreen(navController = navController)
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




























