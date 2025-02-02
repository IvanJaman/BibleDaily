import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.bibledaily.GospelViewModel
import hr.ferit.bibledaily.R
import hr.ferit.bibledaily.ui.theme.BabyBlue
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun GospelScreen(
    viewModel: GospelViewModel,
    navigation: NavController,
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
            items(viewModel.gospelsData.size) { index ->
                val gospel = viewModel.gospelsData[index]
                val isFavourited = viewModel.gospelsData[index].isFavourited
                val date = SimpleDateFormat("dd. MM. yyyy.", Locale.getDefault()).format(gospel.date)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize()
                        .padding(horizontal = 25.dp, vertical = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Text(
                            text = date,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        Text(
                            text = gospel.number,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        Text(
                            text = gospel.mainThought,
                            fontSize = 21.sp,
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        Text(
                            text = gospel.text.replace("\\n", "\n"),
                            fontSize = 21.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    IconButton(
                        onClick = {
                            val updatedGospel = viewModel.gospelsData[index].copy(
                                isFavourited = !viewModel.gospelsData[index].isFavourited
                            )
                            viewModel.updateGospel(updatedGospel)
                            viewModel.gospelsData[index] = updatedGospel
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

                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
                )
            }
        }
    }
}

