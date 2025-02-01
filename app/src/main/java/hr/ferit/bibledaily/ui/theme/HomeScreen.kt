package hr.ferit.bibledaily.ui.theme

import NavBar
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.bibledaily.Routes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navigation: NavController,
    userName: String
) {
    Scaffold(
        topBar = {
            NavBar(
                onBackClick = { navigation.popBackStack() }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hvaljen Isus, $userName",
                fontSize = 26.sp,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Spreman za proučavanje Božje Riječi?",
                fontSize = 21.sp,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(80.dp))

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .width(280.dp)
                    .height(80.dp)
                    .background(color = BabyBlue, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.GOSPEL_SCREEN)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Evanđelja",
                    style = TextStyle(
                        color = Black, fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 26.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .width(280.dp)
                    .height(80.dp)
                    .background(color = BabyBlue, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.READING_SCREEN)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Čitanja",
                    style = TextStyle(
                        color = Black, fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 26.dp, vertical = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .width(280.dp)
                    .height(80.dp)
                    .background(color = BabyBlue, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.PSALM_SCREEN)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Psalmi",
                    style = TextStyle(
                        color = Black, fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 26.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val mockNavController = androidx.navigation.compose.rememberNavController()
    HomeScreen(navigation = mockNavController, userName = "Stipe")
}
