package hr.ferit.bibledaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import hr.ferit.bibledaily.ui.theme.BibleDailyTheme
import android.widget.Toast
import androidx.activity.viewModels
import hr.ferit.bibledaily.ui.theme.HomeScreen
import hr.ferit.bibledaily.ui.theme.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel1 by viewModels<GospelViewModel>()
        val viewModel2 by viewModels<ReadingViewModel>()
        val viewModel3 by viewModels<PsalmViewModel>()
        setContent {
            BibleDailyTheme {
                NavigationController(viewModel1, viewModel2, viewModel3)
            }
        }
    }
}