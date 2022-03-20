package lesincs.github.wetrade.model

import androidx.annotation.DrawableRes

data class PositionItem(
    val number: String,
    val increase: String,
    val name: String,
    val description: String,
    @DrawableRes val resId: Int = 0,
    val isIncrease: Boolean = false
)