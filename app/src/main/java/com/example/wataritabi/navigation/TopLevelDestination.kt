package com.example.wataritabi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Collections
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material.icons.rounded.Collections
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    SCHEDULE(
        selectedIcon = Icons.Outlined.EditCalendar,
        unselectedIcon = Icons.Rounded.EditCalendar,
    ),
    ALBUM(
        selectedIcon = Icons.Outlined.Collections,
        unselectedIcon = Icons.Rounded.Collections,
    ),
    MEMO(
        selectedIcon = Icons.Outlined.EditNote,
        unselectedIcon = Icons.Rounded.EditNote,
    ),
    WALLET(
        selectedIcon = Icons.Outlined.CreditCard,
        unselectedIcon = Icons.Rounded.CreditCard,
    ),
}