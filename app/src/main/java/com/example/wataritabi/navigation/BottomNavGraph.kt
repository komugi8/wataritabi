package com.example.wataritabi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wataritabi.ui.compose.album.AlbumScreen
import com.example.wataritabi.ui.compose.memo.MemoScreen
import com.example.wataritabi.ui.compose.schedule.ScheduleScreen
import com.example.wataritabi.ui.compose.wallet.WalletScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Schedule.route
    ) {
        composable(route = BottomBarScreen.Schedule.route) {
            ScheduleScreen()
        }
        composable(route = BottomBarScreen.Album.route) {
            AlbumScreen()
        }
        composable(route = BottomBarScreen.Memo.route) {
            MemoScreen()
        }
        composable(route = BottomBarScreen.Wallet.route) {
            WalletScreen()
        }
    }
}