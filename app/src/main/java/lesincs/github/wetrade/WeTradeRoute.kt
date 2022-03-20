package lesincs.github.wetrade

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import lesincs.github.wetrade.model.ScreenRoute
import lesincs.github.wetrade.ui.home.Home
import lesincs.github.wetrade.ui.login.LoginPage
import lesincs.github.wetrade.ui.welcome.Welcome

@Composable
fun WeTradeRoute() {
    Box(modifier = Modifier.navigationBarsPadding()) {
        var screenRoute by remember {
            mutableStateOf(ScreenRoute.Welcome)
        }
        when (screenRoute) {
            ScreenRoute.Welcome -> Welcome {
                screenRoute = ScreenRoute.Login
            }
            ScreenRoute.Login -> LoginPage {
                screenRoute = ScreenRoute.Home
            }
            ScreenRoute.Home -> Home()
        }
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color.Transparent)
    }
}