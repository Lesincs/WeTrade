package lesincs.github.wetrade.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lesincs.github.wetrade.R
import lesincs.github.wetrade.model.PositionItem
import lesincs.github.wetrade.model.positions
import lesincs.github.wetrade.ui.theme.Green
import lesincs.github.wetrade.ui.theme.Red
import lesincs.github.wetrade.ui.theme.WeTradeTheme

@Composable
fun Home() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Tabs(
                modifier = Modifier
                    .height(64.dp)
                    .wrapContentSize(align = Alignment.BottomCenter)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .height(32.dp)
                    .wrapContentSize(Alignment.BottomCenter),
                text = "Balance",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .height(48.dp)
                    .wrapContentSize(Alignment.BottomCenter),
                text = "$73,589.01",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier
                    .height(16.dp)
                    .wrapContentSize(Alignment.BottomCenter),
                text = "$+412.25 today",
                style = MaterialTheme.typography.subtitle1,
                color = Green
            )
            Spacer(modifier = Modifier.height(32.dp))
            Transact()
            Spacer(modifier = Modifier.height(16.dp))
            Filters()
            Spacer(modifier = Modifier.height(16.dp))
            Chart()
            Spacer(modifier = Modifier.height(32.dp))
            Surface() {
                PositionSection()
            }
        }
    }
}

@Composable
private fun Chart() {
    Box(Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.ic_home_illos),
            contentDescription = ""
        )
    }
}

@Composable
private fun PositionSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Positions",
            modifier = Modifier
                .height(40.dp)
                .wrapContentSize(Alignment.BottomCenter),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column() {
            for (position in positions) {
                PositionItem(positionItem = position)
            }
        }
    }
}

@Composable
private fun PositionItem(positionItem: PositionItem) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Divider(color = MaterialTheme.colors.onSurface)
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.width(64.dp)) {
                Text(
                    text = positionItem.number,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = positionItem.increase,
                    style = MaterialTheme.typography.body1,
                    color = if (positionItem.isIncrease) {
                        Red
                    } else {
                        Green
                    }
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = positionItem.name,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = positionItem.description,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }
            Image(painter = painterResource(id = positionItem.resId), contentDescription = "")
        }
    }
}

@Composable
private fun Filters() {
    val filters = listOf("Week", "ETFs", "Stocks", "Funds", "Other")
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        for (filter in filters) {
            item {
                Filter(
                    expandable = (filter == "Week"),
                    text = filter
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
private fun Filter(
    expandable: Boolean,
    text: String
) {
    Row(
        modifier = Modifier
            .height(40.dp)
            .border(1.dp, Color.White, MaterialTheme.shapes.large)
            .wrapContentSize(Alignment.Center)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
        if (expandable) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.ExpandMore, contentDescription = "expandMore"
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
private fun Transact() {
    Button(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(48.dp),
        elevation = null, onClick = {}) {
        Text(
            text = "TRANSACT",
            color = MaterialTheme.colors.onPrimary
        )
    }
}


@Composable
private fun Tabs(modifier: Modifier) {
    Row(
        modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "ACCOUNT",
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            modifier = Modifier.alpha(0.5f),
            text = "WATCHLIST",
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground,
        )
        Text(
            modifier = Modifier.alpha(0.5f),
            text = "PROFILE",
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    WeTradeTheme(darkTheme = false) {
        Home()
    }
}

@Preview
@Composable
fun HomePreviewDark() {
    WeTradeTheme(darkTheme = true) {
        Home()
    }
}
