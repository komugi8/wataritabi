package com.example.wataritabi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wataritabi.ui.compose.album.AlbumScreen
import com.example.wataritabi.ui.compose.destination.DestinationScreen
import com.example.wataritabi.ui.compose.map.MapScreen
import com.example.wataritabi.ui.compose.memo.MemoScreen
import com.example.wataritabi.ui.compose.schedule.ScheduleScreen

@Composable
fun NavGraph(navController: NavHostController) {
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
        composable(route = BottomBarScreen.Map.route) {
            MapScreen(navController)
        }
        composable(route = "Destination") {
            DestinationScreen(navController)
        }
    }
}