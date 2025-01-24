package hr.ferit.bibledaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import hr.ferit.bibledaily.ui.theme.BibleDailyTheme
import android.widget.Toast
import hr.ferit.bibledaily.ui.theme.HomeScreen
import hr.ferit.bibledaily.ui.theme.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibleDailyTheme {
                NavigationController()
            }
        }
    }
}
