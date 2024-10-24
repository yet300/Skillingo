package com.hadj.skillingo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Skilingo",
                            color = MaterialTheme.colors.onPrimary,
                            style = MaterialTheme.typography.h3
                        )
                    }
                )
            },
            content = {
                EventsList(events)
            },
            bottomBar = { Text("Bottom bar") }
        )
    }
}

data class Events(
    val name: String,
    val location: String,
    val time: String,
    val date: String,
    val description: String,
)

@Composable
fun EventsList(events: List<Events>) {
    LazyColumn {
        items(events) { event ->
            EventCard(event)
        }
    }
}

@Composable
fun EventCard(event: Events) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.name, style = MaterialTheme.typography.h6)
            Text(text = event.location)
            Text(text = "${event.date}, ${event.time}")
            Text(text = event.description)
        }
    }
}

val events = listOf(
    Events(
        name = "Google I/O",
        location = "Mountain View, California",
        time = "10:00 AM - 5:00 PM",
        date = "May 10, 2023",
        description = "Google's annual developer conference."
    ),
    Events(
        name = "Apple WWDC",
        location = "San Jose, California",
        time = "9:00 AM - 4:00 PM",
        date = "June 5, 2023",
        description = "Apple's annual developer conference."
    )
)