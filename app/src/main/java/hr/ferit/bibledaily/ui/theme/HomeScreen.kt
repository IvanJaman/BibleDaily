package hr.ferit.bibledaily.ui.theme

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
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
import hr.ferit.bibledaily.Routes



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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backarrow),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable {
                            // Handle back arrow click
                        }
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
            }

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
                        navigation.navigate("${Routes.GOSPEL_SCREEN}")
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
                        navigation.navigate("${Routes.READING_SCREEN}")
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
                        navigation.navigate("${Routes.PSALM_SCREEN}")
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
                        navigation.navigate("${Routes.MY_NOTES_SCREEN}")
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
