package org.mathieu.cleanrmapi.ui.screens.location

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mathieu.cleanrmapi.ui.utils.SoundPlayer
import org.mathieu.cleanrmapi.domain.location.Location
import androidx.compose.ui.unit.dp


@Composable
fun LocationDetailsScreen(
    navController: NavController,  // Navigation controller to manage screen transitions
    location: Location            // The location object passed to the screen
) {
    // Main layout for LocationDetails screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),  // Padding around the screen content
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display location name as a heading
        Text(
            text = location.name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Button to simulate clicking and playing the sound
        Button(onClick = {
            // Play the click sound when the button is pressed
            SoundPlayer.playClickSound()
        }) {
            Text(text = "Play Click Sound")
        }

        // Display location details
        Text(text = "Location: ${location.name}")
        Text(text = "Dimension: ${location.dimension}")

        Spacer(modifier = Modifier.height(16.dp))

        // Display list of residents (characters in this location)
        Text(text = "Residents:")
        location.residents.forEach { character ->
            Text(text = character.name)
        }
    }
}

// Preview for LocationDetailsScreen, used to see the UI in design mode
@Preview
@Composable
fun PreviewLocationDetailsScreen() {
    val dummyLocation = Location(
        id = 1,
        name = "Citadel of Ricks",   // Dummy data for testing
        type = "Interdimensional",
        dimension = "C-137",
        residents = listOf()  // Empty list for demo
    )

    // Preview the screen with the dummy data
    LocationDetailsScreen(navController = NavController(), location = dummyLocation)
}
