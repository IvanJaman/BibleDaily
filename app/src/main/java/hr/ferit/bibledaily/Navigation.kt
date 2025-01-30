package hr.ferit.bibledaily

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.bibledaily.ui.theme.GospelScreen
import hr.ferit.bibledaily.ui.theme.HomeScreen
import hr.ferit.bibledaily.ui.theme.MyNotesScreen
import hr.ferit.bibledaily.ui.theme.PsalmScreen
import hr.ferit.bibledaily.ui.theme.ReadingScreen
import hr.ferit.bibledaily.ui.theme.WelcomeScreen

object Routes {
    const val WELCOME_SCREEN = "welcomeScreen"
    const val HOME_SCREEN = "homeScreen/{userName}"
    const val GOSPEL_SCREEN = "gospelScreen"
    const val READING_SCREEN = "readingScreen"
    const val PSALM_SCREEN = "psalmScreen"
    const val MY_NOTES_SCREEN = "myNotesScreen"
}

@Composable
fun NavigationController(viewModel: GospelViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {

        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navigation = navController)
        }

        composable(Routes.HOME_SCREEN) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName")
            HomeScreen(navigation = navController, userName ?: "Gost")
        }

        composable(Routes.GOSPEL_SCREEN) {
            GospelScreen(
                viewModel = viewModel,
                navigation = navController
            )
        }

        composable(Routes.READING_SCREEN) {
            ReadingScreen(navigation = navController)
        }

        composable(Routes.PSALM_SCREEN) {
            PsalmScreen(navigation = navController)
        }

        composable(Routes.MY_NOTES_SCREEN) {
            MyNotesScreen(navigation = navController)
        }
    }
}
