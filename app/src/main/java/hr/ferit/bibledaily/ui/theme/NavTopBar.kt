import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import hr.ferit.bibledaily.R
import hr.ferit.bibledaily.ui.theme.BabyBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
    onBackClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.height(80.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            navigationIconContentColor = BabyBlue,
        ),
        title = {},
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = BabyBlue,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(150.dp)
        )
    }
}
