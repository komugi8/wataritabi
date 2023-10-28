package com.example.wataritabi.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wataritabi.view.album.AlbumScreen
import com.example.wataritabi.view.destination.DestinationScreen
import com.example.wataritabi.view.map.MapScreen
import com.example.wataritabi.view.memo.MemoScreen
import com.example.wataritabi.view.schedule.ScheduleScreen
import com.example.wataritabi.viewmodel.MapViewModel

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
            ScheduleScreen()
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
    }
}