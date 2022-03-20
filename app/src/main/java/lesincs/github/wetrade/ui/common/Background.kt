package lesincs.github.wetrade.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun Background(
    modifier: Modifier = Modifier,
    @DrawableRes resourceId: Int
) {
    Image(
        contentScale = ContentScale.Crop,
        modifier = modifier,
        painter = painterResource(id = resourceId),
        contentDescription = ""
    )
}