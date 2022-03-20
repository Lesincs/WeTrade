package lesincs.github.wetrade.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lesincs.github.wetrade.R
import lesincs.github.wetrade.ui.common.Background
import lesincs.github.wetrade.ui.theme.WeTradeTheme

@Composable
fun LoginPage(navigateToHome: () -> Unit = {}) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Box {
                Background(
                    Modifier
                        .fillMaxWidth()
                        .height(314.dp), R.drawable.bg_login
                )
                WelcomeBack(modifier = Modifier.align(Alignment.Center))
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(modifier = Modifier.fillMaxSize()) {
                EmailAddress()
                Spacer(modifier = Modifier.height(8.dp))
                Password()
                Spacer(modifier = Modifier.height(8.dp))
                Login(onLogin = navigateToHome)
            }
        }
    }
}

@Composable
private fun Login(onLogin: () -> Unit) {
    Button(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(48.dp),
        elevation = null, onClick = onLogin
    ) {
        Text(
            text = "GET STARTED",
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
private fun EmailAddress() {
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(56.dp),
        value = email,
        onValueChange = {
            email = it
        },
        shape = MaterialTheme.shapes.small,
        leadingIcon = {
            Icon(imageVector = Icons.Default.MailOutline, contentDescription = "email")
        },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Unspecified),
        placeholder = {
            Text(
                text = "Email address",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
    )
}

@Composable
private fun Password() {
    var password by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(56.dp),
        value = password, onValueChange = {
            password = it
        },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Unspecified),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Password, contentDescription = "password")
        },
        placeholder = {
            Text(
                text = "Password",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        })
}

@Composable
private fun WelcomeBack(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "Welcome\nBack",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground
    )
}

@Preview
@Composable
fun LoginPagePreviewLight() {
    WeTradeTheme(darkTheme = false) {
        LoginPage()
    }
}

@Preview
@Composable
fun LoginPagePreviewDark() {
    WeTradeTheme(darkTheme = true) {
        LoginPage()
    }
}