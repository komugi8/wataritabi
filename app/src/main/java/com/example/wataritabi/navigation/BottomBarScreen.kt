package com.example.wataritabi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Collections
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.PinDrop
import androidx.compose.material.icons.rounded.Collections
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.material.icons.rounded.NoteAlt
import androidx.compose.material.icons.rounded.PinDrop
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector,
) {
    object Schedule : BottomBarScreen(
        route = "Schedule",
        title = "schedule",
        icon = Icons.Outlined.EditCalendar,
        selectedIcon = Icons.Rounded.EditCalendar
    )

    object Album : BottomBarScreen(
        route = "Album",
        title = "album",
        icon = Icons.Outlined.Collections,
        selectedIcon = Icons.Rounded.Collections
    )

    object Map : BottomBarScreen(
        route = "Map",
        title = "map",
        icon = Icons.Outlined.PinDrop,
        selectedIcon = Icons.Rounded.PinDrop
    )

    object Memo : BottomBarScreen(
        route = "Memo",
        title = "memo",
        icon = Icons.Outlined.NoteAlt,
        selectedIcon = Icons.Rounded.NoteAlt
    )

}