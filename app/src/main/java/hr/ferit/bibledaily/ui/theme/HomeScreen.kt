package hr.ferit.bibledaily.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.bibledaily.R

@Composable
fun HomeScreen(
    navigation: NavController,
    userName: String
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(70.dp)
            )

            Text(
                text = "Hvaljen Isus, $userName",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Spreman za proučavanje Božje Riječi?",
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineMedium
            )

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    
            ) {
                Text(
                    text = "HomeScreen",
                    style = TextStyle(color = Black, fontSize = 15.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(horizontal = 26.dp, vertical =
                    15.dp)
                )
                Text(
                    text = "",
                    style = TextStyle(color = Gray, fontSize = 12.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(horizontal = 26.dp, vertical =
                    15.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val mockNavController = androidx.navigation.compose.rememberNavController()
    HomeScreen(navigation = mockNavController, userName = "Stipe")
}
