package hr.ferit.bibledaily

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.ferit.bibledaily.ui.theme.HomeScreen
import hr.ferit.bibledaily.ui.theme.WelcomeScreen

object Routes {
    const val WELCOME_SCREEN = "welcomeScreen"
    const val HOME_SCREEN = "homeScreen"
}

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navigation = navController)
        }
        composable(Routes.HOME_SCREEN) { HomeScreen(navigation = navController) }
    }
}

