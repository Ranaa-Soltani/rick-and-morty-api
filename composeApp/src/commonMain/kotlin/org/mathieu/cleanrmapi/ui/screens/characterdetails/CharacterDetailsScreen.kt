package org.mathieu.cleanrmapi.ui.screens.characterdetails

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.mathieu.cleanrmapi.ui.utils.SoundPlayer

@Composable
fun CharacterDetailsScreen(navController: NavController, id: Int) {
    Button(onClick = {
        SoundPlayer.playClickSound()
    }) {
        Text("Play Click Sound")
    }
}

