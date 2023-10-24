package com.example.wataritabi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Collections
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Schedule : BottomBarScreen(
        route = "Schedule",
        title = "schedule",
        icon = Icons.Outlined.EditCalendar,
    )

    object Album : BottomBarScreen(
        route = "Album",
        title = "album",
        icon = Icons.Outlined.Collections
    )

    object Memo : BottomBarScreen(
        route = "Memo",
        title = "memo",
        icon = Icons.Outlined.EditNote
    )

    object Wallet : BottomBarScreen(
        route = "Wallet",
        title = "wallet",
        icon = Icons.Outlined.CreditCard
    )
}