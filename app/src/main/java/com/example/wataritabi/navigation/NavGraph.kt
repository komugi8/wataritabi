package com.example.wataritabi.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wataritabi.ui.view.album.AlbumScreen
import com.example.wataritabi.ui.view.destination.DestinationScreen
import com.example.wataritabi.ui.view.map.MapScreen
import com.example.wataritabi.ui.view.memo.MemoScreen
import com.example.wataritabi.ui.view.schedule.ScheduleScreen
import com.example.wataritabi.ui.view.schedule_setting.ScheduleSetting
import com.example.wataritabi.ui.viewmodel.MapViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    mapViewModel: MapViewModel = viewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Schedule.route
    ) {
        composable(route = BottomBarScreen.Schedule.route) {
            ScheduleScreen(navController)
        }
        composable(route = BottomBarScreen.Album.route) {
            AlbumScreen()
        }
        composable(route = BottomBarScreen.Memo.route) {
            MemoScreen()
        }
        composable(route = BottomBarScreen.Map.route) {
            MapScreen(navController, mapViewModel)
        }
        composable(route = "Destination") {
            DestinationScreen(navController, mapViewModel)
        }
        composable(route = "ScheduleSetting") {
            ScheduleSetting()
        }
    }
}