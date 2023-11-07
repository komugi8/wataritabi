package com.example.wataritabi.view.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wataritabi.viewmodel.MapViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    navController: NavController,
    mv: MapViewModel,
) {
    val mapUiState by mv.uiState.collectAsState()
    val tokyoStation = LatLng(35.6809591, 139.7673068)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(tokyoStation, 10f)
    }
    Column {
        Box {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                mapUiState.location.forEach { markerItem ->
                    Marker(
                        state = MarkerState(position = markerItem),
                    )
                }
            }
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate("Destination")
                },
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(
                        end = 64.dp,
                        bottom = 32.dp
                    ),
            ) {
                Icon(Icons.Rounded.Edit, null)
                Text(text = "目的地の編集")
            }
        }
    }
}

@Preview
@Composable
fun MapScreenPreview() {
    // MapScreen()
}