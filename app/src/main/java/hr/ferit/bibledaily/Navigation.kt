package hr.ferit.bibledaily

import GospelScreen
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.bibledaily.data.Gospel
import hr.ferit.bibledaily.ui.theme.FavouritesScreen
import hr.ferit.bibledaily.ui.theme.HomeScreen
import hr.ferit.bibledaily.ui.theme.PsalmScreen
import hr.ferit.bibledaily.ui.theme.ReadingScreen
import hr.ferit.bibledaily.ui.theme.WelcomeScreen

object Routes {
    const val WELCOME_SCREEN = "welcomeScreen"
    const val HOME_SCREEN = "homeScreen/{userName}"
    const val GOSPEL_SCREEN = "gospelScreen"
    const val READING_SCREEN = "readingScreen"
    const val PSALM_SCREEN = "psalmScreen"
    const val FAVOURITES_SCREEN = "favouritesScreen"
}

@Composable
fun NavigationController(
    viewModel1: GospelViewModel,
    viewModel2: ReadingViewModel,
    viewModel3: PsalmViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {

        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navigation = navController)
        }

        composable(Routes.HOME_SCREEN) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName")
            HomeScreen(
                navigation = navController,
                userName ?: "Gost"
            )
        }

        composable(Routes.GOSPEL_SCREEN) {
            GospelScreen(
                viewModel = viewModel1,
                navigation = navController
            )
        }

        composable(Routes.READING_SCREEN) {
            ReadingScreen(
                viewModel = viewModel2,
                navigation = navController)
        }

        composable(Routes.PSALM_SCREEN) {
            PsalmScreen(
                viewModel = viewModel3,
                navigation = navController)
        }

        composable(Routes.FAVOURITES_SCREEN) {
            FavouritesScreen(navigation = navController)
        }
    }
}
