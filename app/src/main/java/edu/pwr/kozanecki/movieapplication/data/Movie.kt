package edu.pwr.kozanecki.movieapplication.data


data class Movie(val title: String, val originalTitle: String, val imageSrc: Int, val description: String, val scenes: List<Int>, val actors: List<Actor>)
