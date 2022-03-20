package lesincs.github.wetrade.ui.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lesincs.github.wetrade.R
import lesincs.github.wetrade.ui.common.Background
import lesincs.github.wetrade.ui.theme.WeTradeTheme

@Composable
fun Welcome(navigateToLogin: () -> Unit = {}) {
    Surface {
        Box(Modifier.fillMaxSize()) {
            Background(Modifier.fillMaxSize(), R.drawable.bg_welcome)
            CenterLogo(Modifier.align(Alignment.Center))
            Buttons(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp),
                onLogin = navigateToLogin
            )
        }
    }
}

@Composable
fun Buttons(modifier: Modifier, onLogin: () -> Unit) {
    Row(modifier = modifier.padding(horizontal = 16.dp)) {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            elevation = null, onClick = {}) {
            Text(text = "GET STARTED")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            elevation = null,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            border = BorderStroke(0.5.dp, MaterialTheme.colors.primary),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            onClick = onLogin
        ) {
            Text(text = "LOG IN", color = MaterialTheme.colors.primary)
        }
    }
}

@Composable
fun CenterLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = ""
    )
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    WeTradeTheme() {
        Welcome()
    }
}