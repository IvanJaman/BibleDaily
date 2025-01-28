package hr.ferit.bibledaily.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import hr.ferit.bibledaily.R

@Composable
fun GospelScreen(
    navigation: NavController
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
                modifier = Modifier.size(100.dp)
            )

            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
                    .wrapContentSize()
            ) {
                Text(
                    text = "Mk 3,31-35\n" +
                            "\n" +
                            "Tko god vrši volju Božju, taj mi je brat i sestra i majka.\n",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
                    .wrapContentSize()
            ) {
                Text(
                    text = "Čitanje svetog Evanđelja po Marku\n" +
                            "\n" +
                            "U ono vrijeme: Dođu Isusova majka i braća njegova. Ostanu vani, a k njemu pošalju neka ga pozovu. Oko njega je sjedjelo mnoštvo. I reknu mu: »Eno vani majke tvoje i braće tvoje, traže te!« On im odgovori: »Tko je majka moja i braća moja?«\n" +
                            "I okruži pogledom po onima što su sjedjeli oko njega u krugu i kaže: »Evo majke moje, evo braće moje! Tko god vrši volju Božju, taj mi je brat i sestra i majka.«\n" +
                            "Riječ Gospodnja.",
                    fontSize = 21.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGospelScreen() {
    val mockNavController = androidx.navigation.compose.rememberNavController()
    GospelScreen(navigation = mockNavController)
}
