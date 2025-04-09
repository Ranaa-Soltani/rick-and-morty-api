package org.mathieu.cleanrmapi.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinContext
import org.mathieu.cleanrmapi.ui.core.Destination
import org.mathieu.cleanrmapi.ui.core.composable
import org.mathieu.cleanrmapi.ui.screens.characterdetails.CharacterDetailsScreen
import org.mathieu.cleanrmapi.ui.screens.characters.CharactersScreen
import org.mathieu.cleanrmapi.ui.screens.episodedetails.EpisodeDetailsScreen

@Composable
fun App() {
    KoinContext {
        MainContent()
    }

}

@Composable
private fun MainContent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "characters") {

        // Définir la route de l'écran des personnages
        composable(route = "characters") {
            CharactersScreen(navController = navController)
        }

        // Correctement passer les arguments de "characterId"
        composable(
            route = "characterDetails/{characterId}"
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: -1
            CharacterDetailsScreen(
                navController = navController,
                id = characterId
            )
        }
        composable(
            route = "episodeDetails/{episodeId}"
        ) { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getString("episodeId")?.toInt() ?: -1
            EpisodeDetailsScreen(
                navController = navController,
                id = episodeId
            )
        }
    }
}