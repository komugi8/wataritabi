package com.example.wataritabi.view.destination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wataritabi.navigation.BottomBarScreen
import com.example.wataritabi.viewmodel.MapViewModel
import com.google.android.gms.maps.model.LatLng

@Composable
fun DestinationScreen(
    navController: NavController,
    mv: MapViewModel,
) {
    var latitude by remember {
        mutableStateOf("")
    }
    var longitude by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = latitude,
            onValueChange = { latitude = it },
            label = { Text("latitude") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = longitude,
            onValueChange = { longitude = it },
            label = { Text("longitude") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row {
            Button(
                onClick = {
                    val enteredLatitude = latitude.toDoubleOrNull() ?: 0.0
                    val enteredLongitude = longitude.toDoubleOrNull() ?: 0.0
                    val newDestination = LatLng(enteredLatitude, enteredLongitude)
                    mv.addDestination(newDestination)
                    navController.navigate(BottomBarScreen.Map.route)
                },
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(text = "add")
            }
            FilledTonalButton(onClick = { navController.navigate(BottomBarScreen.Map.route) }) {
                Text(text = "cancel")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DestinationScreenPreview() {
    //DestinationScreen()
}