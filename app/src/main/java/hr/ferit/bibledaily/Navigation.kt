package hr.ferit.bibledaily

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.bibledaily.ui.theme.HomeScreen
import hr.ferit.bibledaily.ui.theme.WelcomeScreen

object Routes {
    const val WELCOME_SCREEN = "welcomeScreen"
    const val HOME_SCREEN = "homeScreen/{userName}"
}

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navigation = navController)
        }
        composable(
            route = Routes.HOME_SCREEN,
            arguments = listOf(navArgument("userName") { type = NavType.StringType })
        ) { backStackEntry ->
            val encodedUserName = backStackEntry.arguments?.getString("userName")
            val userName = encodedUserName?.let { Uri.decode(it) } ?: "Gost"
            HomeScreen(navigation = navController, userName = userName)
        }
    }
}
