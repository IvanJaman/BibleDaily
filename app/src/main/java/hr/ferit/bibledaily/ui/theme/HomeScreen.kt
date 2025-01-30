package hr.ferit.bibledaily.ui.theme

import NavBar
import android.annotation.SuppressLint
import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.bibledaily.R
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
                    .width(250.dp)
                    .height(70.dp)
                    .background(color = BabyBlue, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.GOSPEL_SCREEN)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Evanđelje dana",
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
                    .width(250.dp)
                    .height(70.dp)
                    .background(color = BabyBlue, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.READING_SCREEN)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Čitanje dana",
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
                    .width(250.dp)
                    .height(70.dp)
                    .background(color = BabyBlue, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.PSALM_SCREEN)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Otpjevni psalam",
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
                    .padding(top = 10.dp)
                    .wrapContentSize()
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(30))
                    .clickable {
                        navigation.navigate(Routes.MY_NOTES_SCREEN)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notes),
                        contentDescription = null,
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)

                    )
                    Text(
                        text = "Moje bilješke",
                        style = TextStyle(
                            color = White, fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(horizontal = 26.dp, vertical = 5.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
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
