package hr.ferit.bibledaily.ui.theme

import NavBar
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.bibledaily.GospelViewModel
import hr.ferit.bibledaily.R

@Composable
fun GospelScreen(
    viewModel: GospelViewModel,
    navigation: NavController
) {
    Scaffold(
        topBar = {
            NavBar(
                onBackClick = { navigation.popBackStack() }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(viewModel.gospelsData.size) {
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .wrapContentSize()
                        .fillMaxWidth()
                ) {
                    Text(
                        text = viewModel.gospelsData[it].Number,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = viewModel.gospelsData[it].MainThought,
                        fontSize = 21.sp,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(top = 30.dp)
                    )
                    Text(
                        text = viewModel.gospelsData[it].Text,
                        fontSize = 21.sp,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(top = 100.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGospelScreen() {
    val mockNavController = androidx.navigation.compose.rememberNavController()
    GospelScreen(viewModel = GospelViewModel(), navigation = mockNavController)
}
