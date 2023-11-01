package com.example.wataritabi.view.destination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wataritabi.viewmodel.MapViewModel
import com.google.android.libraries.places.api.Places

@Composable
fun DestinationScreen(
    navController: NavController,
    mv: MapViewModel,
) {
    val context = LocalContext.current
    val placesClient = Places.createClient(context)
    var query by remember {
        mutableStateOf("")
    }
    Column {
        TextField(
            value = query,
            onValueChange = {
                query = it
                mv.searchPlaces(it, placesClient)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn {
            items(mv.locationAutofill) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = it.primaryText)
//                    Spacer(modifier = Modifier.weight(1f))
//                    Button(
//                        onClick = {
//                            //mv.addDestination(it.placeId)
//                            navController.navigate(BottomBarScreen.Map.route)
//                        }
//                    ) {
//                        Text(text = "add")
//                    }
                }
            }
        }
    }

//    var latitude by remember {
//        mutableStateOf("")
//    }
//    var longitude by remember {
//        mutableStateOf("")
//    }
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(
//            value = latitude,
//            onValueChange = { latitude = it },
//            label = { Text("latitude") },
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        TextField(
//            value = longitude,
//            onValueChange = { longitude = it },
//            label = { Text("longitude") },
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        Row {
//            Button(
//                onClick = {
//                    val enteredLatitude = latitude.toDoubleOrNull() ?: 0.0
//                    val enteredLongitude = longitude.toDoubleOrNull() ?: 0.0
//                    val newDestination = LatLng(enteredLatitude, enteredLongitude)
//                    mv.addDestination(newDestination)
//                    navController.navigate(BottomBarScreen.Map.route)
//                },
//                modifier = Modifier.padding(end = 16.dp)
//            ) {
//                Text(text = "add")
//            }
//            FilledTonalButton(onClick = { navController.navigate(BottomBarScreen.Map.route) }) {
//                Text(text = "cancel")
//            }
//        }
//    }
}


@Preview(showBackground = true)
@Composable
fun DestinationScreenPreview() {
    //DestinationScreen()
}