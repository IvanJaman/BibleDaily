package hr.ferit.bibledaily.ui.theme

import NavBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.bibledaily.PsalmViewModel
import hr.ferit.bibledaily.R
import hr.ferit.bibledaily.ReadingViewModel

@Composable
fun PsalmScreen(
    viewModel: PsalmViewModel,
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
            items(viewModel.psalmsData.size) { index ->
                val psalm = viewModel.psalmsData[index]
                val isFavourited = viewModel.psalmsData[index].isFavourited

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .wrapContentSize()
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                    ) {
                        Text(
                            text = psalm.number,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        Text(
                            text = psalm.chorus,
                            fontSize = 21.sp,
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        Text(
                            text = psalm.text.replace("\\n", "\n"),
                            fontSize = 21.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    IconButton(
                        onClick = {
                            val updatedPsalm = viewModel.psalmsData[index].copy(
                                isFavourited = !viewModel.psalmsData[index].isFavourited
                            )
                            viewModel.updatePsalm(updatedPsalm)
                            viewModel.psalmsData[index] = updatedPsalm
                        },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = null,
                            tint = if (isFavourited) BabyBlue else Color.DarkGray
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPsalmScreen() {
    val mockNavController = androidx.navigation.compose.rememberNavController()
    PsalmScreen(viewModel = PsalmViewModel(), navigation = mockNavController)
}
